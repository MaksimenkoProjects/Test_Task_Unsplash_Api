package com.example.testtaskunsplashapi.di

import com.example.testtaskunsplashapi.MainActivity
import com.example.testtaskunsplashapi.di.annotations.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    fun mainActivity(): MainActivity

}