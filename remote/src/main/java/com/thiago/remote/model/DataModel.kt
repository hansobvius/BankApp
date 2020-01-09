package com.thiago.remote.model

import com.google.gson.annotations.SerializedName

class DataModel(
        @SerializedName("userAccount")val result: RemoteUserModel,
        @SerializedName("error") val error: ErrorModel)