package com.ivanmorgillo.corsoandroid.teama.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ivanmorgillo.corsoandroid.teama.DetailScreenEvent
import com.ivanmorgillo.corsoandroid.teama.DetailViewModel
import com.ivanmorgillo.corsoandroid.teama.R
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModel()
    private val args: DetailFragmentArgs by navArgs()

    /** Qui ci va la lista da passare all'adapter
    // private val ingredientsList: List<IngredientUI> = loadIngredients() */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        return rootView
    }

    // Equivalente alla onCreate di un activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // La nostra recycler view dovrà accettare in ingresso l'oggetto che conterrà i dettagli.
        val adapter = ListIngredientAdapter()
        recipedetails_list.adapter = adapter
        val recipeId = args.recipeId
        if (recipeId == 0L) {
            // Torna indietro nella schermata da cui provieni.
            findNavController().popBackStack()
        } else {
            Timber.d("RecipeId= $recipeId")
        }
        viewModel.send(DetailScreenEvent.OnReady(recipeId))

        // Istruzion e che passa l'oggetto all'adapter
        // adapter.setIngredients(ingredientsList)
    }
}
