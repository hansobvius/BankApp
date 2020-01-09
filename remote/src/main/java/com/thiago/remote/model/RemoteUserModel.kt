package com.thiago.remote.model

import com.google.gson.annotations.SerializedName

class RemoteUserModel(
        @SerializedName("userId") val userId: Int,
        @SerializedName("name") val name: String,
        @SerializedName("bankAccount")val bankAccount: String,
        @SerializedName("agency")val agency: String,
        @SerializedName("balance")val balance: Double)