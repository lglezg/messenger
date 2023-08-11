package com.lglez.messenger.authentication.signup.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.lglez.messenger.authentication.signup.data.SignUpRepositoryImp
import com.lglez.messenger.authentication.signup.domain.SignUpRepository
import com.lglez.messenger.authentication.signup.domain.SignUpUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateConfirmPasswordUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateEmailUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateFormUseCase
import com.lglez.messenger.authentication.signup.domain.ValidateNameUseCase
import com.lglez.messenger.authentication.signup.domain.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object SignUpModule {
    @Provides
    fun provideSignUpRepository(
        firabaseAuth: FirebaseAuth,
        firebaseFirestore: FirebaseFirestore
    ): SignUpRepository {
        return SignUpRepositoryImp(firabaseAuth, firebaseFirestore)
    }

    @Provides
    fun provideValidateEmailUseCase(): ValidateEmailUseCase {
        return ValidateEmailUseCase()
    }

    @Provides
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase {
        return ValidatePasswordUseCase()
    }

    @Provides
    fun provideValidateConfirmPasswordUseCase(): ValidateConfirmPasswordUseCase {
        return ValidateConfirmPasswordUseCase()
    }

    @Provides
    fun provideValidateNameUseCase(): ValidateNameUseCase {
        return ValidateNameUseCase()
    }

    @Provides
    fun provideFormUseCase(
        validateNameUseCase: ValidateNameUseCase,
        validateEmailUseCase: ValidateEmailUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
        validateConfirmPasswordUseCase: ValidateConfirmPasswordUseCase
    ): ValidateFormUseCase {
        return ValidateFormUseCase(
            validateNameUseCase,
            validateEmailUseCase,
            validatePasswordUseCase,
            validateConfirmPasswordUseCase
        )
    }
}