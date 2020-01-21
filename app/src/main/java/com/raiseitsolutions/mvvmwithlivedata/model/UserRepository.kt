package com.raiseitsolutions.mvvmwithlivedata.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import org.json.JSONObject

class UserRepository(application: Application) {
    val url = "https://api.github.com/users"
    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(application)
    lateinit var users: Array<User>
    var mutableLiveData: MutableLiveData<Array<User>>? = null


    fun getUserData():  MutableLiveData<Array<User>>{
        if (mutableLiveData == null){
            mutableLiveData = MutableLiveData()
        }
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val jsonObject = JSONObject(response)
                Log.d("JASONOBJECTVALUE", jsonObject.toString())
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                users = gson.fromJson(response,Array<User>::class.java)
                mutableLiveData!!.value = users
            },
            Response.ErrorListener {error->
                error.printStackTrace()
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
        return mutableLiveData as MutableLiveData<Array<User>>
    }
}