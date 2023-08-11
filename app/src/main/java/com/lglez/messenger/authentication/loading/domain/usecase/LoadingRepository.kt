package com.lglez.messenger.authentication.loading.domain.usecase

import com.google.firebase.auth.FirebaseUser

interface LoadingRepository {
    fun getCurrentSession(): FirebaseUser?
}