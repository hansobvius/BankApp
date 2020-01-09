package com.thiago.remote.model

import com.google.gson.annotations.SerializedName

class UserDetailModel(
        @SerializedName("title") val title: String,
        @SerializedName("desc") val description: String,
        @SerializedName("date") val date: String,
        @SerializedName("value") val accountValue: Float)