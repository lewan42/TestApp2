// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.dimensions.fence.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory implements Factory<DimensionsFenceDao> {
  private final DimensionsFenceDaoModule module;

  private final Provider<AppRoomDatabase> appDatabaseProvider;

  public DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory(DimensionsFenceDaoModule module,
      Provider<AppRoomDatabase> appDatabaseProvider) {
    this.module = module;
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public DimensionsFenceDao get() {
    return providesDimensionsDAO(module, appDatabaseProvider.get());
  }

  public static DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory create(
      DimensionsFenceDaoModule module, Provider<AppRoomDatabase> appDatabaseProvider) {
    return new DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory(module, appDatabaseProvider);
  }

  public static DimensionsFenceDao providesDimensionsDAO(DimensionsFenceDaoModule instance,
      AppRoomDatabase appDatabase) {
    return Preconditions.checkNotNull(instance.providesDimensionsDAO(appDatabase), "Cannot return null from a non-@Nullable @Provides method");
  }
}
