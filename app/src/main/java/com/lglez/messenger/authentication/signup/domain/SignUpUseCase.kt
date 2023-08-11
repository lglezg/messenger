package com.lglez.messenger.authentication.signup.domain

import com.lglez.messenger.core.domain.NetworkResult
import com.lglez.models.domain.User
import com.lglez.models.mapers.UserMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
){
    suspend operator fun invoke(user: User): Flow<NetworkResult<User>> {
         return signUpRepository.signUpUser(UserMapper.toData(user))
    }
}