package com.example.testtaskunsplashapi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.testtaskunsplashapi.R
import com.example.testtaskunsplashapi.databinding.FragmentMainBinding
import com.example.testtaskunsplashapi.ui.base.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        androidInjector().inject(this)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.unsplashRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        viewModel.loadProgress.observeForever {
            if(it == false){
                binding.loadProgressBar.visibility = View.GONE
            }
        }

        viewModel.connect.observeForever {
            if (it == false){
                binding.loadProgressBar.visibility = View.GONE
                binding.notConnect.visibility = View.VISIBLE
                binding.textNotConnect.visibility = View.VISIBLE
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}