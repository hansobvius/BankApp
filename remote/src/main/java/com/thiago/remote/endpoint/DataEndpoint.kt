package com.thiago.remote.endpoint

import com.thiago.remote.model.DataModel
import com.thiago.remote.model.DetaillModel
import com.thiago.remote.model.UserDetailModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface DataEndpoint {

    @FormUrlEncoded
    @POST("login")
    suspend fun getLogin(
            @Field("user") user: String,
            @Field("password") password: String): Response<DataModel>

    @GET("statements/{id}")
    suspend fun getUserDetail(
            @Path("id") id: Int): Response<DetaillModel>

}