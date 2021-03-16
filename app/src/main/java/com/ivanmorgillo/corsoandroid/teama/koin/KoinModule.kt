package com.ivanmorgillo.corsoandroid.teama.koin

import com.google.gson.Gson
import com.ivanmorgillo.corsoandroid.teama.MainViewModel
import com.ivanmorgillo.corsoandroid.teama.Tracking
import com.ivanmorgillo.corsoandroid.teama.TrackingImpl
import com.ivanmorgillo.corsoandroid.teama.category.CategoryRepository
import com.ivanmorgillo.corsoandroid.teama.category.CategoryRepositoryImpl
import com.ivanmorgillo.corsoandroid.teama.category.CategoryViewModel
import com.ivanmorgillo.corsoandroid.teama.detail.DetailViewModel
import com.ivanmorgillo.corsoandroid.teama.detail.RecipeDetailsRepository
import com.ivanmorgillo.corsoandroid.teama.detail.RecipeDetailsRepositoryImpl
import com.ivanmorgillo.corsoandroid.teama.favourite.FavouriteRepository
import com.ivanmorgillo.corsoandroid.teama.favourite.FavouriteRepositoryImpl
import com.ivanmorgillo.corsoandroid.teama.favourite.FavouriteViewModel
import com.ivanmorgillo.corsoandroid.teama.network.NetworkAPI
import com.ivanmorgillo.corsoandroid.teama.network.NetworkApiImpl
import com.ivanmorgillo.corsoandroid.teama.recipe.RecipeRepositoryImpl
import com.ivanmorgillo.corsoandroid.teama.recipe.RecipeViewModel
import com.ivanmorgillo.corsoandroid.teama.recipe.RecipesRepository
import com.ivanmorgillo.corsoandroid.teama.settings.SettingsRepository
import com.ivanmorgillo.corsoandroid.teama.settings.SettingsRepositoryImpl
import com.ivanmorgillo.corsoandroid.teama.settings.SettingsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<NetworkAPI> {
        NetworkApiImpl(androidApplication().cacheDir)
    }
    single<RecipesRepository> {
        RecipeRepositoryImpl(api = get())
    }
    single<RecipeDetailsRepository> {
        RecipeDetailsRepositoryImpl(api = get())
    }
    single<CategoryRepository> {
        CategoryRepositoryImpl(api = get())
    }
    single<FavouriteRepository> {
        FavouriteRepositoryImpl(fireStoreDatabase = get())
    }
    single<SettingsRepository> {
        SettingsRepositoryImpl(context = androidContext())
    }
    single<Tracking> {
        TrackingImpl()
    }


    viewModel { MainViewModel(repository = get(), tracking = get()) }
    viewModel { CategoryViewModel(repository = get(), tracking = get()) }
    viewModel { RecipeViewModel(repository = get(), tracking = get()) }
    viewModel { DetailViewModel(repository = get(), tracking = get(), favouritesRepository = get()) }
    viewModel { FavouriteViewModel(repository = get(), tracking = get(), settingsRepository = get()) }
    viewModel { SettingsViewModel(repository = get(), tracking = get()) }
}
