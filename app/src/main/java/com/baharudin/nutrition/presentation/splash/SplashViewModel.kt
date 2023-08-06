package com.baharudin.nutrition.presentation.splash

import android.view.View
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baharudin.nutrition.data.util.datastore.DataStoreRepository
import com.baharudin.nutrition.presentation.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel(){

    private val _isLoading : MutableState<Boolean> = mutableStateOf(true)
    val isLoading : State<Boolean> = _isLoading

    private val _startDestination : MutableState<String> = mutableStateOf(Screen.Welcome.route)
    val startDestination : State<String> = _startDestination

    init {
        viewModelScope.launch {
            dataStoreRepository.readOnBoardingState().collect{complete ->
                if (complete){
                    _startDestination.value = Screen.Home.route
                }else{
                    _startDestination.value = Screen.Welcome.route
                }
            }
            _isLoading.value = false
        }
    }
}