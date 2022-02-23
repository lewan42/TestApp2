package dev.fabula.android.app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.Reusable

interface GsonProvider {
    fun provideGson(): Gson
}

@Module
class GsonModule {

    @Reusable
    @Provides
    fun provideGson() : Gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd''HH:mm:ssZ")
        .create()

}

inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object: TypeToken<T>() {}.type)