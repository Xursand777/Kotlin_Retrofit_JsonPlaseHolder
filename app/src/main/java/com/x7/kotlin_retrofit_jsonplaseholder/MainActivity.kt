package com.x7.kotlin_retrofit_jsonplaseholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.x7.kotlin_retrofit_jsonplaseholder.databinding.ActivityMainBinding
import com.x7.kotlin_retrofit_jsonplaseholder.model.Post
import com.x7.kotlin_retrofit_jsonplaseholder.model.PostsPhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     lateinit var postAdapter: PostAdapter
     var arrayList=ArrayList<Post>()
     var arrayListphotos=ArrayList<PostsPhoto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrofit Build
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //Retrofit bilan Api ni bog'lash kk
        val api:Api=retrofit.create(Api::class.java)

        //Zapros qayerga ketishi belgilanadi

        val call:Call<ArrayList<PostsPhoto>> = api.getAllPhotos()

        call.enqueue(object :Callback<ArrayList<PostsPhoto>>{
            override fun onResponse(
                call: Call<ArrayList<PostsPhoto>>,
                response: Response<ArrayList<PostsPhoto>>
            ) {
                if(response.code()==200){
                  Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()

                    arrayListphotos = response.body()!!
                  binding.recyclerview.layoutManager=GridLayoutManager(this@MainActivity,2)
                  postAdapter=PostAdapter(this@MainActivity,arrayListphotos)
                  binding.recyclerview.adapter=postAdapter
              }

            }

            override fun onFailure(call: Call<ArrayList<PostsPhoto>>, t: Throwable) {

            }

        })








//        val call:Call<ArrayList<Post>> = api.getAllPosts()
//
//        //Zapros go
//        call.enqueue(object :Callback<ArrayList<Post>>{
//            override fun onResponse(
//                call: Call<ArrayList<Post>>,
//                response: Response<ArrayList<Post>>
//            ) {
//
//                //Natija
//              if(response.code()==200){
//                  Toast.makeText(this@MainActivity,response.code().toString(),Toast.LENGTH_SHORT).show()
//                   arrayList = response.body()!!
//                  binding.recyclerview.layoutManager=LinearLayoutManager(this@MainActivity)
//                  postAdapter=PostAdapter(this@MainActivity,arrayList)
//                  binding.recyclerview.adapter=postAdapter
//              }
//            }
//
//            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
//
//            }
//
//        })

    }
}