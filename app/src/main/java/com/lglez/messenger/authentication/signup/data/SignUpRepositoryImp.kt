package com.lglez.messenger.authentication.signup.data

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.lglez.messenger.authentication.signup.domain.SignUpRepository
import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.data.UserFb
import com.lglez.models.domain.User
import com.lglez.models.mapers.UserMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class SignUpRepositoryImp @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore,
) : SignUpRepository {
     override suspend fun signUpUserWithEmail(user: UserFb): NetworkResult<AuthResult> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password)
                .await()
            NetworkResult.Success(authResult)
        } catch (e: Exception) {
            NetworkResult.Error(e)
        }
    }

    override suspend fun signUpUser(user: UserFb): Flow<NetworkResult<User>> = flow {
        emit(NetworkResult.Loading)
        val authResult = signUpUserWithEmail(user)
        if (authResult is NetworkResult.Success) {
            val userId = authResult.data.user?.uid
            if (userId != null) {
                val db = firebaseFirestore.collection(Collections.USERS)
                try {
                    db.document(userId).set(user).await()
                    emit(NetworkResult.Success(UserMapper.toDomain(user)))
                } catch (e: Exception) {
                    emit(NetworkResult.Error(Exception("Error al crear usario")))
                }
            } else {
                emit(NetworkResult.Error(Exception("Error al registrar usuario")))
            }
        } else {
            emit(NetworkResult.Error(Exception("Error al registrar usuario")))
        }
    }


}