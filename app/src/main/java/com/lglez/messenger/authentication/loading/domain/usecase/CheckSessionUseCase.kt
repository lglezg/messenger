package com.lglez.messenger.authentication.loading.domain.usecase


import javax.inject.Inject

class CheckSessionUseCase @Inject constructor(
    private val loadingRepository: LoadingRepository
) {

    operator fun invoke(): Boolean{
        val session = loadingRepository.getCurrentSession()
        return session != null
    }
}