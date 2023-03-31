package com.undel.libraryrjd.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val ApiService: ApiServise){
    suspend fun getAllDocument() = ApiService.getAllDocuments()
}