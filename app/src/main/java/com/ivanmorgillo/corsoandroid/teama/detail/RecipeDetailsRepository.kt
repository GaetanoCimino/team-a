package com.ivanmorgillo.corsoandroid.teama.detail

import com.ivanmorgillo.corsoandroid.teama.network.LoadRecipeDetailsResult
import com.ivanmorgillo.corsoandroid.teama.network.NetworkAPI

interface RecipeDetailsRepository {
    suspend fun loadRecipeDetails(idMeal: Long): LoadRecipeDetailsResult
}

class RecipeDetailsRepositoryImpl(private val api: NetworkAPI) : RecipeDetailsRepository {
    override suspend fun loadRecipeDetails(idMeal: Long): LoadRecipeDetailsResult {
        return if (idMeal == -1L) {
            api.loadRandomRecipe()
        } else {
            api.loadRecipeDetails(idMeal)
        }
    }
}

data class RecipeDetails(
    val name: String,
    val image: String,
    val video: String,
    val idMeal: Long,
    val ingredients: List<Ingredient>,
    val instructions: String,
    val area: String,
    val notes: String,
)
