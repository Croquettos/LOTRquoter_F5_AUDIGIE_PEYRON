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

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val viewGroup = view
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = mList[position]
        viewHolder.textView.text = movie.name

        viewHolder.viewGroup.setOnClickListener {
            Log.e(movie.name, "ON CLICK")
            fragment.gotoQuote(movie._id)
        }

    }

    override fun getItemCount() = mList.size

    fun updateData(i: MutableLiveData<MutableList<Movie>>){
        Log.e(i.value.toString(), "UPDATE DATA")
        i.value?.let { mList.addAll(it)
        Log.e("ADD " + it, "UPDATE DATA")}
    }
}