package dev.fabula.android.wire.contact.api

import dev.fabula.android.wire.contact.model.ContactWireRequest
import dev.fabula.android.wire.contact.model.ContactWireResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ContactWireApi {

    @POST("api/v1/contact-wire/")
    suspend fun update(
        @Body carrierWire: ContactWireRequest
    ): Response<ContactWireResponse>
}