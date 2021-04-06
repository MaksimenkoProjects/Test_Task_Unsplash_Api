package com.example.testtaskunsplashapi.repository

import com.example.testtaskunsplashapi.models.UnsplashPhoto

interface AppRepository {
    suspend fun getAllUnsplashPhotos(): List<UnsplashPhoto>?
}