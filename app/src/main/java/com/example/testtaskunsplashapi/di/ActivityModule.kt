package com.example.testtaskunsplashapi.di

import com.example.testtaskunsplashapi.di.annotations.FragmentScope
import com.example.testtaskunsplashapi.ui.main.MainFragment
import com.example.testtaskunsplashapi.ui.photo.PhotoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    fun mainFragment(): MainFragment


    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    fun photoFragment(): PhotoFragment

}