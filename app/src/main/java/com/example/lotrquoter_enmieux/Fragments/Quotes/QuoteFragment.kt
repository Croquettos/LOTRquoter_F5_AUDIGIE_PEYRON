package com.example.lotrquoter_enmieux.Fragments.Quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotrquoter_enmieux.Fragments.Movies.MovieAdapter
import com.example.lotrquoter_enmieux.R

class QuoteFragment : Fragment() {

    companion object {
        fun newInstance() = QuoteFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.quote_fragment, container, false)
        val quoteViewModel: QuoteViewModel by activityViewModels()
        val quoteText : TextView = view.findViewById<TextView>(R.id.quoteText)
        val character : TextView = view.findViewById<TextView>(R.id.character)
        quoteViewModel.selected.observe(this) {

        }
        return view
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}