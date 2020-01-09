package com.thiago.remote.model

import com.google.gson.annotations.SerializedName

class DetaillModel(@SerializedName("statementList")val detailUser: List<UserDetailModel>)