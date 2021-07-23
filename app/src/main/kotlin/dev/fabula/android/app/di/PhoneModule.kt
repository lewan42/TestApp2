package dev.fabula.android.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

interface PhoneProvider {
    fun providePhoneNumberUtil(): PhoneNumberUtil
}

@Module
class PhoneModule {

    @Reusable
    @Provides
    fun providePhoneNumberUtil(context: Context) = PhoneNumberUtil.createInstance(context)

}