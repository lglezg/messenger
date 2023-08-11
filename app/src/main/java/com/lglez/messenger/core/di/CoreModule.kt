package com.lglez.messenger.core.di

import com.lglez.messenger.core.domain.use.cases.ValidateEmptyTextFieldUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
 @InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    fun provideValidateEmptyTextFieldUseCase(): ValidateEmptyTextFieldUseCase{
        return ValidateEmptyTextFieldUseCase()
    }
}