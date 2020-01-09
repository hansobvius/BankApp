package com.thiago.data

import com.thiago.remote.model.RemoteUserModel
import com.thiago.remote.model.UserDetailModel

interface DataImplementation {

    suspend fun loginData(): RemoteUserModel?

    suspend fun getUserDetail(id: Int): List<UserDetailModel>?
}