package com.learnwithsajib.addressbookretrofit.api

import com.learnwithsajib.addressbookretrofit.models.User
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun getAllUser(): List<User>
}