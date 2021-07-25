package com.sersh.murashevtechnicaltask.ui.detail

import android.R.attr.defaultValue
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sersh.murashevtechnicaltask.R
import com.sersh.murashevtechnicaltask.databinding.FragmentDetailedBinding


class DetailedFragment: Fragment() {

    val LOG_TAG = "DetailedFragment"
    lateinit var binding: FragmentDetailedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = this.arguments
        val myId = bundle!!.getInt("id", defaultValue)
        Log.d(LOG_TAG, "from bundl" +  myId.toString())
        val viewModel = DetailedViewModel(myId)
        viewModel.getCharaterResultLiveData()?.observe(viewLifecycleOwner, Observer {
            it.let {
                viewModel.initData()
            }
        })
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detailed, container, false)
       binding.setViewModel(viewModel)
       return binding.getRoot()
    }

}