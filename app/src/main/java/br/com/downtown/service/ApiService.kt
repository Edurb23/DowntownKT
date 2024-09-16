package br.com.downtown.service


import br.com.downtown.model.User
import br.com.downtown.model.UserResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/api/users/register")
    fun registerUser(@Body user: User): Call<UserResponse>

    @POST("/api/nottoken/login")
    fun loginUser(@Body user: User): Call<UserResponse>

    @GET("api/nottoken/user")
    fun getUserByEmail(@Query("email") email: String): Call<User>

}