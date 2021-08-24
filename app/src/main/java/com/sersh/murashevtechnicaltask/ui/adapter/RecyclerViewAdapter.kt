package com.sersh.murashevtechnicaltask.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.sersh.murashevtechnicaltask.R
import com.sersh.murashevtechnicaltask.data.model.Result
import com.sersh.murashevtechnicaltask.MainActivity
import com.sersh.murashevtechnicaltask.databinding.ItemRecycleBinding


class RecyclerViewAdapter(private var array: List<Result>?, private var activity: FragmentActivity?) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRecycleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_recycle, parent, false

        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity: Result = array!!.get(position)
        holder.itemBinding.setResult(entity)
        holder.itemBinding.constraint.setOnClickListener {

            (activity as MainActivity).showDetailFragment(array!!.get(position).id)
        }
        holder.itemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        Log.d("MainActivity", "size array" + array!!.size)
        return array!!.size
    }

    class ViewHolder(ResultLayoutBinding: ItemRecycleBinding) :
        RecyclerView.ViewHolder(ResultLayoutBinding.getRoot()) {
        var itemBinding: ItemRecycleBinding = ResultLayoutBinding

    }


}