package com.ivanmorgillo.corsoandroid.teama.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanmorgillo.corsoandroid.teama.databinding.RecipeItemBinding
import timber.log.Timber

class IngredientAdapter : RecyclerView.Adapter<RecipeByIngredientViewHolder>() {

    var recipes = emptyList<RecipeByIngredientUI>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeByIngredientViewHolder {
       val binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeByIngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeByIngredientViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int {
        Log.d("SHOT","LISTA SIZE${recipes.size}")
        return recipes.size
    }

    fun setRecipesByIngredient(items: List<RecipeByIngredientUI>){
        recipes = items
        notifyDataSetChanged()
    }
}

class RecipeByIngredientViewHolder(private val binding:RecipeItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RecipeByIngredientUI){
        Log.d("SHOT", "${binding.recipeTitle}")
    }

}
