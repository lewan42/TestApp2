// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.station.peregon.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class StationPeregonModuleDao_ProvidesStationPeregonDAOFactory implements Factory<StationPeregonDao> {
  private final StationPeregonModuleDao module;

  private final Provider<AppRoomDatabase> appDatabaseProvider;

  public StationPeregonModuleDao_ProvidesStationPeregonDAOFactory(StationPeregonModuleDao module,
      Provider<AppRoomDatabase> appDatabaseProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public StationPeregonDao get() {
    return providesStationPeregonDAO(module, appDatabaseProvider.get());
  }

  public static StationPeregonModuleDao_ProvidesStationPeregonDAOFactory create(
      StationPeregonModuleDao module, Provider<AppRoomDatabase> appDatabaseProvider) {
    return new StationPeregonModuleDao_ProvidesStationPeregonDAOFactory(module, appDatabaseProvider);
  }

  public static StationPeregonDao providesStationPeregonDAO(StationPeregonModuleDao instance,
      AppRoomDatabase appDatabase) {
    return Preconditions.checkNotNull(instance.providesStationPeregonDAO(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}