package com.lglez.messenger.authentication.signin.di

import com.google.firebase.auth.FirebaseAuth
import com.lglez.messenger.authentication.signin.data.SignInRepositoryImp
import com.lglez.messenger.authentication.signin.domain.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SignInModule {

    @Provides
    fun provideSignInRepository(firebaseAuth: FirebaseAuth) : SignInRepository = SignInRepositoryImp(firebaseAuth)
}