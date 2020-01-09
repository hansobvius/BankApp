package com.thiago.remote

import com.thiago.remote.endpoint.DataImplementation

class RemoteProject: RemoteImplementation {

    override fun fetchData(): DataImplementation {
        return DataImplementation
    }
}