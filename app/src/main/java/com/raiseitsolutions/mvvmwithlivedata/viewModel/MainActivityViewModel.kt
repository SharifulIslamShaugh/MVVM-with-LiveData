package com.raiseitsolutions.mvvmwithlivedata.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.raiseitsolutions.mvvmwithlivedata.model.User
import com.raiseitsolutions.mvvmwithlivedata.model.UserRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
      var userRepository = UserRepository(application)
    fun  getAllUserData(): LiveData <Array<User>>{
        return userRepository.getUserData()
    }
}