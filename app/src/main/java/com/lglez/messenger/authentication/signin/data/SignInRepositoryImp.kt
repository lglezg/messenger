package com.lglez.messenger.authentication.signin.data

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.lglez.messenger.authentication.signin.domain.SignInRepository
import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.data.UserFb
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SignInRepositoryImp @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : SignInRepository {
    override suspend fun signIn(user: UserFb): Flow<NetworkResult<Boolean>> = flow{
        emit(NetworkResult.Loading)
        try {
           firebaseAuth.signInWithEmailAndPassword(user.email, user.password)
                .await()
            emit(NetworkResult.Success(true))
        } catch ( e: Exception){
            emit(NetworkResult.Error(e))
        }
    }

}