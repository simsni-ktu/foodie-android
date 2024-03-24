package com.ktu.foodie.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktu.foodie.api.Resource
import com.ktu.foodie.api.models.UserCredentials
import com.ktu.foodie.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ktu.foodie.proto.User
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {


    fun getUserFromDataStore() = authRepository.getUserFromDataStore()

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            when (val result =
                authRepository.login(UserCredentials(email = email, password = password))) {
                is Resource.Success -> {
                    result.data?.let {
                        updateUserStore(it)
                        onSuccess()
                    }
                }

                is Resource.Error -> {

                }

                is Resource.Loading -> {

                }
            }
        }
    }

    fun register(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            when (val result =
                authRepository.register(UserCredentials(email = email, password = password))) {
                is Resource.Success -> {
                    onSuccess()
                }

                is Resource.Error -> {

                }

                is Resource.Loading -> {

                }
            }
        }
    }

    fun updateUserStore(user: User?) {
        viewModelScope.launch {
            authRepository.updateUserStore(user)
        }
    }
}