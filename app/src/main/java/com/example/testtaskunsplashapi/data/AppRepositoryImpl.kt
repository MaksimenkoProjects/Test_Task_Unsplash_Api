package com.example.testtaskunsplashapi.data

import android.util.Log
import com.example.testtaskunsplashapi.R
import com.example.testtaskunsplashapi.models.UnsplashPhoto
import com.example.testtaskunsplashapi.repository.AppRepository
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepositoryImpl @Inject constructor(
    val networkClient: NetworkClient
): AppRepository {
    override suspend fun getAllUnsplashPhotos(): List<UnsplashPhoto>? {


        try {
            val resultNetwork = networkClient.client?.loadPhotos()?.await()
            val resultPhotoList = arrayListOf<UnsplashPhoto>()
            resultNetwork?.forEach {
                resultPhotoList.add(UnsplashPhoto(it.urls.thumb, it.urls.full))
            }
            return resultPhotoList
        }catch (e: Exception){
            return null
        }


    }
}