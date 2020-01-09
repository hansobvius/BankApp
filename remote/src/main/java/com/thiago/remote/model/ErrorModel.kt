package com.thiago.remote.model

import com.google.gson.annotations.SerializedName

class ErrorModel(
        @SerializedName("code") val code: Int,
        @SerializedName("message") val message: String)