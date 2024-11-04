package br.com.downtown.service


import br.com.downtown.model.UpdateUser
import br.com.downtown.model.User
import br.com.downtown.model.UserResponse
import br.com.downtown.model.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("/register")
    fun registerUser(@Body user: User): Call<UserResponse>

    @POST("/login")
    fun loginUser(@Body user: User): Call<UserResponse>

    @GET("/user")
    fun getUser(@Header("Authorization") token: String): Call<User>

    @PUT("/user")
    fun updateUser(@Header("Authorization") token: String, @Body user: UpdateUser): Call<UserResponse>

    @DELETE("/user")
    fun deleteUser(@Header("Authorization") token: String): Call<Void>

    //// PRODUTOS

    @GET("/produtos/categoria/{categoria}")
    fun getProductsByCategory(@Path("categoria") category: String): Call<List<Product>>


}
