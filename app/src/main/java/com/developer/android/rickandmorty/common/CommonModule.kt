package com.developer.android.rickandmorty.common

import com.developer.android.rickandmorty.main.api.RickAndMortyApi
import com.developer.android.rickandmorty.utils.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CommonModule {
    fun createRetrofit() = module {
        single {
            val interceptor =  HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(Utils.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RickAndMortyApi::class.java)
        }
    }
}