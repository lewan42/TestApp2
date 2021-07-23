package dev.fabula.android.railway.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.railway.ui.RailwayFragment

@Component(
    modules = [
        RailwayModule::class,
        RailwayDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface RailwayComponent {

    companion object {
        fun create(context: Context): RailwayComponent {
            return DaggerRailwayComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: RailwayFragment)
}