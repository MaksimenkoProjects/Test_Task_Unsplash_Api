package com.example.testtaskunsplashapi.data

import com.example.testtaskunsplashapi.models.UnsplashModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos/")
    fun loadPhotos(
        @Query("client_id") clientId: String = "8PSYRYJ1Sxx5tCZ11KCGHn5Xh-UsZ6nMuA4e3rLQR04",
        @Query("per_page") pageSize: Int = 30
    ): Deferred<UnsplashModel>


}


