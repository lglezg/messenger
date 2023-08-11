package com.lglez.messenger.authentication.signup.domain

import com.google.firebase.auth.AuthResult
import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.data.UserFb
import com.lglez.models.domain.User
import kotlinx.coroutines.flow.Flow

interface SignUpRepository {
    suspend fun signUpUserWithEmail(user: UserFb): NetworkResult<AuthResult>
    suspend fun signUpUser(user: UserFb): Flow<NetworkResult<User>>
}