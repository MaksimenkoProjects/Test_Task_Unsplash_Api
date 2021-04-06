package com.example.testtaskunsplashapi.ui.main

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskunsplashapi.MainActivity
import com.example.testtaskunsplashapi.R
import com.example.testtaskunsplashapi.data.AppRepositoryImpl
import com.example.testtaskunsplashapi.di.annotations.FragmentScope
import com.example.testtaskunsplashapi.models.UnsplashPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
        val repositoryImpl: AppRepositoryImpl,
        val mainActivity: MainActivity
) : ViewModel() {

    val adapter: UnsplashPhotoAdapter
    val resultListPhoto = MutableLiveData<List<UnsplashPhoto>>()
    var loadProgress = MutableLiveData(true)
    var connect = MutableLiveData(true)



    init {

        adapter = UnsplashPhotoAdapter(R.layout.item_unsplash_photo, arrayListOf(), this)

        resultListPhoto.observeForever {
            adapter.listLinkPhoto = it
            adapter.notifyDataSetChanged()
        }

        viewModelScope.launch(Dispatchers.Main) {
            val result = repositoryImpl.getAllUnsplashPhotos()
            if (result != null){
                resultListPhoto.value = result
                loadProgress.value = false
            }else{
                connect.value = false
            }
        }
    }

    fun openPhoto(urlPhoto: String){
        val bundle = Bundle()
        bundle.putString("urlUnsplashPhoto",urlPhoto)
        mainActivity.navController.navigate(R.id.action_mainFragment_to_photoFragment, bundle)
    }

}