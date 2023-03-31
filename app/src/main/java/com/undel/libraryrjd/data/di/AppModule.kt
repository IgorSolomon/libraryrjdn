package com.undel.libraryrjd.data.di

import com.undel.libraryrjd.data.network.ApiServise
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun base_url() = "https://sdo-bot.ru/"

    @Provides
    @Singleton
    fun provideRetrofit(base_url: String) : ApiServise =
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServise::class.java)

}