package com.nareshittechnologies.retrofit

import com.google.gson.annotations.SerializedName


data class PostRequest (

  @SerializedName("title"  ) var title  : String? = null,
  @SerializedName("body"   ) var body   : String? = null,
  @SerializedName("userId" ) var userId : Int?    = null

)