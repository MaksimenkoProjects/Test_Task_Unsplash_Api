package com.example.testtaskunsplashapi.di

import androidx.lifecycle.ViewModel
import com.example.testtaskunsplashapi.di.annotations.ViewModelKey
import com.example.testtaskunsplashapi.ui.main.MainViewModel
import com.example.testtaskunsplashapi.ui.photo.PhotoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(viewModel: MainViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    fun bindsPhotoViewModel(viewModel: PhotoViewModel): ViewModel

}