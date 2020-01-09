package com.thiago.remote.endpoint

import com.thiago.remote.service.ServiceApi

object DataImplementation {

    private val SERVICE_API: ServiceApi

    init{
        SERVICE_API = ServiceApi()
    }

    val service: DataEndpoint by lazy{
        SERVICE_API.getDataService().create(DataEndpoint::class.java)
    }
}