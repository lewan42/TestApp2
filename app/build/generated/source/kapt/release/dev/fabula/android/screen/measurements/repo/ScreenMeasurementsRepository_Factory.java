// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.screen.measurements.repo;

import dagger.internal.Factory;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import dev.fabula.android.support.dao.SupportDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ScreenMeasurementsRepository_Factory implements Factory<ScreenMeasurementsRepository> {
  private final Provider<StationPeregonDao> stationPeregonDaoProvider;

  private final Provider<SupportDao> supportDaoProvider;

  public ScreenMeasurementsRepository_Factory(Provider<StationPeregonDao> stationPeregonDaoProvider,
      Provider<SupportDao> supportDaoProvider) {
    this.stationPeregonDaoProvider = stationPeregonDaoProvider;
    this.supportDaoProvider = supportDaoProvider;
  }

  @Override
  public ScreenMeasurementsRepository get() {
    return newInstance(stationPeregonDaoProvider.get(), supportDaoProvider.get());
  }

  public static ScreenMeasurementsRepository_Factory create(
      Provider<StationPeregonDao> stationPeregonDaoProvider,
      Provider<SupportDao> supportDaoProvider) {
    return new ScreenMeasurementsRepository_Factory(stationPeregonDaoProvider, supportDaoProvider);
  }

  public static ScreenMeasurementsRepository newInstance(StationPeregonDao stationPeregonDao,
      SupportDao supportDao) {
    return new ScreenMeasurementsRepository(stationPeregonDao, supportDao);
  }
}