package com.undel.libraryrjd.data.network

import com.undel.libraryrjd.data.models.documents
import retrofit2.Response
import retrofit2.http.GET

interface ApiServise {

    @GET("/library")
    suspend fun getAllDocuments()  : Response<List<documents>>
}