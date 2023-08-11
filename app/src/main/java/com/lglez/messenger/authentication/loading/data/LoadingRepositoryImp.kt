package com.lglez.messenger.authentication.loading.data

import com.google.firebase.auth.FirebaseAuth
import com.lglez.messenger.authentication.loading.domain.usecase.LoadingRepository
import javax.inject.Inject

class LoadingRepositoryImp @Inject constructor(
    private val  firebaseAuth: FirebaseAuth
) : LoadingRepository{
    override fun getCurrentSession() =
        firebaseAuth.currentUser

}