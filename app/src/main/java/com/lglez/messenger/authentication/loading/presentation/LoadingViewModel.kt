package com.lglez.messenger.authentication.loading.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.lglez.messenger.authentication.loading.domain.usecase.CheckSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val checkSessionUseCase: CheckSessionUseCase
): AndroidViewModel(Application()){

    fun checkSession() = checkSessionUseCase.invoke()

}