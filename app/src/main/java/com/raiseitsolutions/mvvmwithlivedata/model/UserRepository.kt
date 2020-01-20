package com.raiseitsolutions.mvvmwithlivedata.model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class UserRepository(application: Application) {
    val url = "https://api.github.com/users"
    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(application)
    lateinit var users: Array<User>
    lateinit var mutableLiveData: MutableLiveData<Array<User>>

    fun getUserData(): MutableLiveData<Array<User>>{
    if (mutableLiveData == null){
        var resultLiveData = MutableLiveData<User>()
    }
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
               // val jsonObject = JSONObject(response)
                val gsonBuilder:GsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                users = gson.fromJson(response,Array<User>::class.java)
                mutableLiveData.value = users
            },
            Response.ErrorListener {error->
                error.printStackTrace()
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
        return mutableLiveData
    }
}