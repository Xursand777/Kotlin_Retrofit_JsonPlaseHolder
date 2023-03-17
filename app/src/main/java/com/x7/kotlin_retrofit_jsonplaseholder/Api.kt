package com.x7.kotlin_retrofit_jsonplaseholder


import com.x7.kotlin_retrofit_jsonplaseholder.model.Post
import com.x7.kotlin_retrofit_jsonplaseholder.model.PostsPhoto
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("posts")
    fun getAllPosts():Call<ArrayList<Post>>

    @GET("photos")
    fun getAllPhotos():Call<ArrayList<PostsPhoto>>


}