package com.example.testtaskunsplashapi.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskunsplashapi.R
import com.example.testtaskunsplashapi.databinding.FragmentPhotoBinding
import com.example.testtaskunsplashapi.ui.base.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PhotoFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: PhotoViewModel
    private var _binding: FragmentPhotoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        androidInjector().inject(this)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)
        viewModel = ViewModelProvider(this, factory).get(PhotoViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.photo = arguments?.getString("urlUnsplashPhoto").toString()


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}