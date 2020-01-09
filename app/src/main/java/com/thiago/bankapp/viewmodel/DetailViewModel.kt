package com.thiago.bankapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiago.data.DataResourceManager
import com.thiago.data.repository.DataRepository
import com.thiago.remote.model.UserDetailModel
import kotlinx.coroutines.*

class DetailViewModel(): ViewModel() {

    private var manager: DataResourceManager = DataResourceManager()
    private var scope: CoroutineScope
    private var job = SupervisorJob()

    init{
        scope = CoroutineScope(job + Dispatchers.Main )
        getDetailData()
    }

    private var _detailUser = MutableLiveData<List<UserDetailModel>>()
    val detailUser: LiveData<List<UserDetailModel>>
        get() = _detailUser

    fun getDetailData(){
        scope.launch{
            val dataUser = withContext(Dispatchers.IO){
                manager.getUserDetail(1)
            }
            _detailUser.value = dataUser
        }
    }

}