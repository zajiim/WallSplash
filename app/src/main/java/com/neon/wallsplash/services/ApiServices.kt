package com.neon.wallsplash.services

import com.neon.wallsplash.models.PexelImageResponse
import com.neon.wallsplash.utils.Apikey
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiServices {
    @Headers("Authorization: " + Apikey.API_KEY)
    @GET("curated")
    suspend fun getHomeResponse(
        @Query("page") page: Int,

    ): PexelImageResponse

//    @Headers("Authorization: " + Apikey.API_KEY)
//    @GET("search")
//    suspend fun getSearchResults(
//        @Query("query") query: String,
//        @Query("page") page: Int,
//    ): PexelImageResponse

}