package com.thiago.bankapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiago.data.DataResourceManager
import com.thiago.data.repository.DataRepository
import com.thiago.remote.model.RemoteUserModel
import kotlinx.coroutines.*

class UserViewModel(): ViewModel() {

    private var manager: DataResourceManager = DataResourceManager()
    private var scope: CoroutineScope
    private var job = SupervisorJob()

    init{
        scope = CoroutineScope(job + Dispatchers.Main )
    }

    private var _data = MutableLiveData<RemoteUserModel>()
    val data: LiveData<RemoteUserModel>
        get() = _data

    private var _dataRetrieved = MutableLiveData<Boolean>()
    val dataRetrieved: LiveData<Boolean>
        get() = _dataRetrieved

    fun getBalance(): String{
        return data.value!! .balance.toString()
    }

    fun getBankAccount(): String{
        return data.value!!.bankAccount + "/" + data.value!!.agency
    }

    fun getData(){
        scope.launch{
            val data = withContext(Dispatchers.IO){
                manager.loginData()
            }
            if(data != null){
                _dataRetrieved.value = true
            }else{
                _dataRetrieved.value = false
            }
            _data.value = data
        }
    }
}