package br.com.downtown.auth

import br.com.downtown.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFit {
    private const val BASE_URL = "https://720012d7-e454-4ecd-b17f-5c57127f3b8b-00-yn4v2xotucba.kirk.replit.dev/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}