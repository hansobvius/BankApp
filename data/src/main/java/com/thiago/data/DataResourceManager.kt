package com.thiago.data

import com.thiago.data.repository.BaseRepositoryImplementation
import com.thiago.remote.model.RemoteUserModel
import com.thiago.remote.model.UserDetailModel

class DataResourceManager(): DataImplementation, BaseRepositoryImplementation() {

    override suspend fun loginData(): RemoteUserModel? = loginRepository()

    override suspend fun getUserDetail(id: Int): List<UserDetailModel>?  = userRepository(id)
}