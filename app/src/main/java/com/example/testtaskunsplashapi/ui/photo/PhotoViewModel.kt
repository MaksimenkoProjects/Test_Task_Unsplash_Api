package com.example.testtaskunsplashapi.ui.photo

import androidx.lifecycle.ViewModel
import com.example.testtaskunsplashapi.MainActivity
import com.example.testtaskunsplashapi.R
import javax.inject.Inject

class PhotoViewModel @Inject constructor(
    val mainActivity: MainActivity
): ViewModel() {

    var photo: String = "error"

    fun closePhoto(){
        mainActivity.navController.navigate(R.id.action_photoFragment_to_mainFragment)
    }

}