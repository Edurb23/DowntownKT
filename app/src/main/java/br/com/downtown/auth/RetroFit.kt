package br.com.downtown.auth

import br.com.downtown.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFit {
    private const val BASE_URL = "https://11ad8802-f738-4e6b-b77d-dc4dacbdd19a-00-1l727ob9ktncy.spock.replit.dev:3000/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}