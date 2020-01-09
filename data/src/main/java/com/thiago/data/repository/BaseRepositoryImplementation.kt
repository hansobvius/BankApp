package com.thiago.data.repository

import com.thiago.remote.model.RemoteUserModel
import com.thiago.remote.model.UserDetailModel

open class BaseRepositoryImplementation {

    private val dataRepository: DataRepository

    init{
        dataRepository = DataRepository()
    }

    suspend fun loginRepository(): RemoteUserModel? = dataRepository.fetchData()

    suspend fun userRepository(id: Int): List<UserDetailModel>? = dataRepository.initDetailFetch(id)
}