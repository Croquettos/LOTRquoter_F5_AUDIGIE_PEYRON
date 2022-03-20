package com.example.lotrquoter_enmieux.Fragments.Quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lotrquoter_enmieux.DTOs.Quote
import com.example.lotrquoter_enmieux.R
import java.lang.Thread.sleep
import java.util.*

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
        quoteViewModel.movie_id.observe(this) {
            quoteViewModel.updateData()
            quoteText.text = quoteViewModel.selected.value?.dialog
            character.text = quoteViewModel.character.value?.name
        }
        return view
    }

}