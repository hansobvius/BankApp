package com.thiago.data.repository

import android.util.Log
import com.thiago.remote.RemoteProject
import com.thiago.remote.model.RemoteUserModel
import com.thiago.remote.model.UserDetailModel
import kotlinx.coroutines.*
import okhttp3.Response

class DataRepository {

    private val remoteProject: RemoteProject = RemoteProject()
    private var scope: CoroutineScope
    private var job = SupervisorJob()

    init{
        scope = CoroutineScope(job + Dispatchers.Main )
    }

    suspend fun initLogin(): RemoteUserModel? {
        val request = remoteProject
                .fetchData()
                .service
                .getLogin("test_user", "Test@1")

        if(checkResponse(request.raw(), request.body()?.error!!.code)){
            Log.i("test", request.body()?.result!!.name)
            return request.body()!!.result
        }else{
            return  null
        }
    }

    suspend fun initDetailFetch(id: Int): List<UserDetailModel>?{
        val request = remoteProject
                .fetchData()
                .service
                .getUserDetail(id)

        if(request.isSuccessful){
            return request.body()?.detailUser
        }else{
            return null
        }
    }

    suspend fun fetchData() = initLogin()

    private fun checkResponse(response: Response, codeError: Int): Boolean{
        return if(response.isSuccessful && codeError != 53) true else false
    }
}