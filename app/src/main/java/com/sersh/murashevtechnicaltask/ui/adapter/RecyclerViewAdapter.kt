package com.sersh.murashevtechnicaltask.ui.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.sersh.murashevtechnicaltask.R

import com.sersh.murashevtechnicaltask.data.model.Result
import com.sersh.murashevtechnicaltask.databinding.ItemRecycleBinding
import com.sersh.murashevtechnicaltask.ui.main.MainActivity


class RecyclerViewAdapter(var array: List<Result>?, var activity:FragmentActivity? ):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{
    val LOG_TAG = "RecyclerViewAdapter"

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemRecycleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_recycle, parent, false

        )
     Log.d(LOG_TAG, "onCreateViewHolder")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val entity: com.sersh.murashevtechnicaltask.data.model.Result = array!!.get(position)
        holder.itemBinding.setResult(entity)
        holder.itemBinding.constraint.setOnClickListener {
            Log.d(LOG_TAG, "click work")
            Log.d(LOG_TAG, "id " + array!!.get(position).id )
            (activity as MainActivity).showDetailFragment(array!!.get(position).id)
        }
       holder.itemBinding.executePendingBindings()
        Log.d(LOG_TAG, "onBindViewHolder")

    }
    override fun getItemCount(): Int {
        Log.d(LOG_TAG, "array!!.size")
        return array!!.size
    }

    class ViewHolder(ResultLayoutBinding: ItemRecycleBinding) :
        RecyclerView.ViewHolder(ResultLayoutBinding.getRoot()) {
        var itemBinding: ItemRecycleBinding

        init {
            itemBinding = ResultLayoutBinding
        }
    }



}