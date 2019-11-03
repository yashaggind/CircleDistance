package com.app.ui.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.model.UserEntity
import com.app.repository.UserRepository

class UserViewModel(private val userRepository : UserRepository) : ViewModel() {

    // FOR DATA --
    private lateinit var userData : MutableLiveData<ArrayList<UserEntity>>

    fun getUserData() : LiveData<ArrayList<UserEntity>> {

        userData = MutableLiveData()

        userData.postValue(userRepository.getUserListAsync())

        return userData
    }
}