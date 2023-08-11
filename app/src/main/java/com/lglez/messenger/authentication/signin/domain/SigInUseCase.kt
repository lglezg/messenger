package com.lglez.messenger.authentication.signin.domain

import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.domain.User
import com.lglez.models.mapers.UserMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SigInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {

    suspend operator fun invoke(user: User): Flow<NetworkResult<Boolean>>{
        return signInRepository.signIn(UserMapper.toData(user))
    }
}