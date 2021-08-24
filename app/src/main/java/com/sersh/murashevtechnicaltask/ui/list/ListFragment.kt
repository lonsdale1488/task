package com.sersh.murashevtechnicaltask.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sersh.murashevtechnicaltask.R
import com.sersh.murashevtechnicaltask.databinding.FragmentListBinding
import com.sersh.murashevtechnicaltask.ui.adapter.RecyclerViewAdapter

class ListFragment : Fragment() {


    private lateinit var mBinding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ListViewModel()
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        mBinding.listViewModel = viewModel
        initRecyclerView(viewModel)
        return mBinding.root
    }

    private fun initRecyclerView(viewModel: ListViewModel) {
        mBinding.recyclerView.layoutManager = LinearLayoutManager(activity)
        mBinding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        viewModel.getCharaterResultLiveData()?.observe(viewLifecycleOwner, Observer {
            it.let {
                val adapter = RecyclerViewAdapter(it.data?.results, activity)
                mBinding.recyclerView.adapter = adapter
            }
        })
    }

}