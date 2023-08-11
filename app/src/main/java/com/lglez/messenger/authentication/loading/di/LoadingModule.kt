package com.lglez.messenger.authentication.loading.di

import com.google.firebase.auth.FirebaseAuth
import com.lglez.messenger.authentication.loading.data.LoadingRepositoryImp
import com.lglez.messenger.authentication.loading.domain.usecase.CheckSessionUseCase
import com.lglez.messenger.authentication.loading.domain.usecase.LoadingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LoadingModule {

    @Provides
    fun provideLoadingRepository(firebaseAuth: FirebaseAuth) : LoadingRepository = LoadingRepositoryImp(firebaseAuth)

    @Provides
    fun provideCheckSessionUseCase(loadingRepository: LoadingRepository) : CheckSessionUseCase{
        return CheckSessionUseCase(loadingRepository)
    }
}