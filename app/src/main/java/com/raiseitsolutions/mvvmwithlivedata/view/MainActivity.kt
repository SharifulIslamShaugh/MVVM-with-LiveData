package com.raiseitsolutions.mvvmwithlivedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raiseitsolutions.mvvmwithlivedata.R
import com.raiseitsolutions.mvvmwithlivedata.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainActivityViewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        mainActivityViewModel.getAllUserData().observe(this, Observer {

        })
    }
}
