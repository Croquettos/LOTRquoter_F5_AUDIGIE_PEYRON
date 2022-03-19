package com.example.lotrquoter_enmieux.Fragments.Movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrquoter_enmieux.R

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.movie_fragment, container, false)
        val movieViewModel: MovieViewModel by activityViewModels()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MovieFragment.context)

        viewModel.selected.observe(this) {
            val movieAdapter = movieViewModel.selected.value?.let { MovieAdapter(ArrayList(), this) }
            recyclerView.adapter = movieAdapter
            movieAdapter?.updateData(movieViewModel.selected)
            movieAdapter?.notifyDataSetChanged()
        }
        return view
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}