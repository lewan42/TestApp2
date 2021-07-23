package dev.fabula.android.wire.contact.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.wire.contact.api.ContactWireApi
import retrofit2.Retrofit

@Module
class ContactWireApiModule {
    @Provides
    fun getCarrierWireApi(retrofit: Retrofit): ContactWireApi {
        return retrofit.create(ContactWireApi::class.java)
    }
}