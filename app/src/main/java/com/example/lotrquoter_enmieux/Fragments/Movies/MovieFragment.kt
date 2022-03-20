package com.example.lotrquoter_enmieux.Fragments.Movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrquoter_enmieux.Fragments.Quotes.QuoteViewModel
import com.example.lotrquoter_enmieux.R

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.movie_fragment, container, false)
        val movieViewModel: MovieViewModel by activityViewModels()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MovieFragment.context)
        movieViewModel.selected.observe(this) {
            val movieAdapter = movieViewModel.selected.value?.let { MovieAdapter(ArrayList(),this) }
            recyclerView.adapter = movieAdapter
            movieAdapter?.updateData(movieViewModel.selected)
            movieAdapter?.notifyDataSetChanged()
        }

        return view
    }

    fun gotoQuote(movie_id : String) {
        Log.e(movie_id, "GO TO QUOTE")
        val quoteViewModel: QuoteViewModel by activityViewModels()
        quoteViewModel.movie_id.value = movie_id
        view?.let { Navigation.findNavController(it).navigate(R.id.action_movieFragment_to_quoteFragment) }
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}