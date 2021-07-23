// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.dimensions.fence.repo;

import dagger.internal.Factory;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao;
import dev.fabula.android.platform.dao.PlatformDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DimensionsFenceRepository_Factory implements Factory<DimensionsFenceRepository> {
  private final Provider<PlatformDao> platformDaoProvider;

  private final Provider<DimensionsFenceDao> dimensionsFenceDaoProvider;

  private final Provider<CreateMeasurementsDao> createMeasurementsDaoProvider;

  private final Provider<MeasurementTypeDao> measurementTypeDaoProvider;

  public DimensionsFenceRepository_Factory(Provider<PlatformDao> platformDaoProvider,
      Provider<DimensionsFenceDao> dimensionsFenceDaoProvider,
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<MeasurementTypeDao> measurementTypeDaoProvider) {
    this.platformDaoProvider = platformDaoProvider;
    this.dimensionsFenceDaoProvider = dimensionsFenceDaoProvider;
    this.createMeasurementsDaoProvider = createMeasurementsDaoProvider;
    this.measurementTypeDaoProvider = measurementTypeDaoProvider;
  }

  @Override
  public DimensionsFenceRepository get() {
    return newInstance(platformDaoProvider.get(), dimensionsFenceDaoProvider.get(), createMeasurementsDaoProvider.get(), measurementTypeDaoProvider.get());
  }

  public static DimensionsFenceRepository_Factory create(Provider<PlatformDao> platformDaoProvider,
      Provider<DimensionsFenceDao> dimensionsFenceDaoProvider,
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<MeasurementTypeDao> measurementTypeDaoProvider) {
    return new DimensionsFenceRepository_Factory(platformDaoProvider, dimensionsFenceDaoProvider, createMeasurementsDaoProvider, measurementTypeDaoProvider);
  }

  public static DimensionsFenceRepository newInstance(PlatformDao platformDao,
      DimensionsFenceDao dimensionsFenceDao, CreateMeasurementsDao createMeasurementsDao,
      MeasurementTypeDao measurementTypeDao) {
    return new DimensionsFenceRepository(platformDao, dimensionsFenceDao, createMeasurementsDao, measurementTypeDao);
  }
}
