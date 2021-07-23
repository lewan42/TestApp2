package dev.fabula.android.list.items.di

import android.content.Context
import dagger.Component
import dev.fabula.android.app.BaseApp
import dev.fabula.android.app.di.AppComponent
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule
import dev.fabula.android.canopy.dao.CanopyDao
import dev.fabula.android.canopy.di.CanopyDaoModule
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule
import dev.fabula.android.list.items.ui.ListItemsFragment
import dev.fabula.android.platform.di.PlatformDaoModule
import dev.fabula.android.support.di.SupportDaoModule

@Component(
    modules = [
        ListItemsModule::class,
        PlatformDaoModule::class,
        BridgeCrossingDaoModule::class,
        SupportDaoModule::class,
        DimensionsFenceDaoModule::class,
        CanopyDaoModule::class
    ],
    dependencies = [AppComponent::class]
)
interface ListItemsComponent {

    companion object {
        fun create(context: Context): ListItemsComponent {
            return DaggerListItemsComponent.builder()
                .appComponent((context.applicationContext as BaseApp).appComponent).build()
        }
    }

    fun inject(fragment: ListItemsFragment)
}