package dev.fabula.android.bridge.crossing.di

import dagger.Module
import dagger.Provides
import dev.fabula.android.bridge.crossing.api.BridgeApi
import retrofit2.Retrofit

@Module
class BridgeApiModule {
    @Provides
    fun getBridgeApi(retrofit: Retrofit): BridgeApi {
        return retrofit.create(BridgeApi::class.java)
    }
}