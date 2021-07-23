package dev.fabula.android.auth.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.auth.remote.AuthService
import retrofit2.Retrofit

@Module
class AuthApiModule {
    @Provides
    fun getApodNasaApi(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}