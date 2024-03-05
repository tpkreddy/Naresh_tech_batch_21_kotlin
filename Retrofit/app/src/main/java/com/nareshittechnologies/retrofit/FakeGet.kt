package com.nareshittechnologies.retrofit

import com.google.gson.annotations.SerializedName


data class FakeGet (

  @SerializedName("userId" ) var userId : Int?    = null,
  @SerializedName("id"     ) var id     : Int?    = null,
  @SerializedName("title"  ) var title  : String? = null,
  @SerializedName("body"   ) var body   : String? = null

)