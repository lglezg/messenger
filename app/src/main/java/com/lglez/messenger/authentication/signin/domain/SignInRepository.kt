package com.lglez.messenger.authentication.signin.domain

import com.google.firebase.auth.AuthResult
import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.data.UserFb
import kotlinx.coroutines.flow.Flow

interface SignInRepository {
    suspend fun signIn(user: UserFb) : Flow<NetworkResult<Boolean>>
}