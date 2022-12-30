package com.neon.wallsplash.services.repository


import com.neon.wallsplash.services.ApiServices
import com.neon.wallsplash.services.RetrofitInstance

class MainRepository {

    fun retroServices(): ApiServices = RetrofitInstance.apiServices
}