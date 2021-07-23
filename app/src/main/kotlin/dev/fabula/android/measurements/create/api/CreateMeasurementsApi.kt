package dev.fabula.android.measurements.create.api

import dev.fabula.android.measurements.model.MeasurementRequest
import dev.fabula.android.measurements.model.MeasurementResponse
import retrofit2.Response
import retrofit2.http.*

interface CreateMeasurementsApi {

    @POST("api/v1/measurement/")
    suspend fun create(
        @Body measurement: MeasurementRequest
    ): Response<MeasurementResponse>

    @PATCH("api/v1/measurement/{uid}/")
    suspend fun update(
        @Path("uid") uid: String,
        @Body dimensionsFence: MeasurementRequest
    ): Response<MeasurementResponse>
}