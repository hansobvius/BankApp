package com.thiago.remote

import com.thiago.remote.endpoint.DataImplementation

interface RemoteImplementation {

    fun fetchData(): DataImplementation
}