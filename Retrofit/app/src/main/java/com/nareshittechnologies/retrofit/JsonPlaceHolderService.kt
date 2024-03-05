package com.nareshittechnologies.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonPlaceHolderService {
    @GET("posts/1")
    fun getData():Call<FakeGet>

    @POST("posts")
    fun postData(@Body postRequest: PostRequest):Call<PostResponse>
}