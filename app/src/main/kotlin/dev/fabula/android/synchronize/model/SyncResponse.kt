package dev.fabula.android.synchronize.model

import com.google.gson.annotations.SerializedName
import dev.fabula.android.bridge.crossing.model.BridgeCrossing
import dev.fabula.android.canopy.model.Canopy
import dev.fabula.android.dimensions.fence.model.DimensionsFence
import dev.fabula.android.measurements.model.Measurement
import dev.fabula.android.measurements.type.model.MeasurementType
import dev.fabula.android.platform.model.Platform
import dev.fabula.android.railway.model.Railway
import dev.fabula.android.section.model.RailwaySection
import dev.fabula.android.station.peregon.model.StationPeregon
import dev.fabula.android.support.model.Support
import dev.fabula.android.wire.carrier.model.CarrierWire
import dev.fabula.android.wire.contact.model.ContactWire

data class SyncResponse(
    @SerializedName("results")
    val results: List<BodyResponse>
)

data class BodyResponse(
    @SerializedName("measurementtype") val measurementType: List<MeasurementType>,
    @SerializedName("measurement")     val measurement: List<Measurement>,
    @SerializedName("railway")         val railway: List<Railway>,
    @SerializedName("railwaysector")   val railwaysector: List<RailwaySection>,
    @SerializedName("station")         val station: List<StationPeregon>,
    @SerializedName("platform")        val platforms: List<Platform>,
    @SerializedName("opora")           val supports: List<Support>,
    @SerializedName("bridge")          val bridges: List<BridgeCrossing>,
    @SerializedName("contactwire")     val contactWire: List<ContactWire>,
    @SerializedName("mainwire")        val carrierWire: List<CarrierWire>,
    @SerializedName("gabaritnaves")    val gabaritnaves: List<Canopy>,
    @SerializedName("gabarittor")      val gabarittor: List<DimensionsFence>
)

