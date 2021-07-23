package dev.fabula.android.section.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.section.ui.RailwaySectionFragment

@Component(
    modules = [
        RailwaySectionModule::class,
        RailwaySectionDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface RailwaySectionComponent {

    companion object {
        fun create(context: Context): RailwaySectionComponent {
            return DaggerRailwaySectionComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent)
                .build()
        }
    }

    fun inject(fragment: RailwaySectionFragment)
}