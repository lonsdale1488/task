package com.sersh.murashevtechnicaltask

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sersh.murashevtechnicaltask.ui.detail.DetailedFragment
import com.sersh.murashevtechnicaltask.ui.list.ListFragment


class MainActivity : AppCompatActivity() {

    private var id = 0
    private var bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "i'm work")
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)
        Log.d("MainActivity", "i'm work")
        id = savedInstanceState?.getInt("id") ?: 0
        if (getScreenOrientation()) {
            showListFragment()
        } else {
            showListFragment()
            showDetailFragment(id)
        }

    }

    private fun getScreenOrientation(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }


    private fun showListFragment() {
        Log.d("MainActivity", "showListFragment()")
        if (ListFragment().isVisible) return
        replace(R.id.container, ListFragment())

    }

    fun showDetailFragment(id: Int) {
        bundle.putInt("id", id)
        val detailedFragment = DetailedFragment()
        detailedFragment.setArguments(bundle)
        this.id = id
        if (getScreenOrientation()) {
            replaceWithBackStack(R.id.container, detailedFragment)
        } else {
            replace(R.id.container_two, detailedFragment)
        }
    }

    private fun replace(containerViewId: Int, fragment: Fragment) {
        var aFM = supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }

    private fun replaceWithBackStack(containerViewId: Int, fragment: Fragment) {
        var aFM = supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .addToBackStack("0")
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("id", id)
    }


}