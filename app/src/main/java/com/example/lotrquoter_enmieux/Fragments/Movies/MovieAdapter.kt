package com.example.lotrquoter_enmieux.Fragments.Movies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrquoter_enmieux.DTOs.Movie
import com.example.lotrquoter_enmieux.R

class MovieAdapter(private val mList: ArrayList<Movie>,
                    private val fragment: MovieFragment
                    ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = mList[position]
        viewHolder.textView.text = movie.name
    }

    override fun getItemCount() = mList.size

    fun updateData(i: MutableLiveData<MutableList<Movie>>){
        Log.e(i.value.toString(), "UPDATE DATA")
        i.value?.let { mList.addAll(it) }
    }
}