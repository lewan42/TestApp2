// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.measurements.create.repo;

import dagger.internal.Factory;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CreateMeasurementsRepository_Factory implements Factory<CreateMeasurementsRepository> {
  private final Provider<CreateMeasurementsDao> createMeasurementsDaoProvider;

  private final Provider<CanopyDao> canopyDaoProvider;

  private final Provider<DimensionsFenceDao> dimensionsFenceDaoProvider;

  public CreateMeasurementsRepository_Factory(
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<CanopyDao> canopyDaoProvider,
      Provider<DimensionsFenceDao> dimensionsFenceDaoProvider) {
    this.createMeasurementsDaoProvider = createMeasurementsDaoProvider;
    this.canopyDaoProvider = canopyDaoProvider;
    this.dimensionsFenceDaoProvider = dimensionsFenceDaoProvider;
  }

  @Override
  public CreateMeasurementsRepository get() {
    return newInstance(createMeasurementsDaoProvider.get(), canopyDaoProvider.get(), dimensionsFenceDaoProvider.get());
  }

  public static CreateMeasurementsRepository_Factory create(
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<CanopyDao> canopyDaoProvider,
      Provider<DimensionsFenceDao> dimensionsFenceDaoProvider) {
    return new CreateMeasurementsRepository_Factory(createMeasurementsDaoProvider, canopyDaoProvider, dimensionsFenceDaoProvider);
  }

  public static CreateMeasurementsRepository newInstance(
      CreateMeasurementsDao createMeasurementsDao, CanopyDao canopyDao,
      DimensionsFenceDao dimensionsFenceDao) {
    return new CreateMeasurementsRepository(createMeasurementsDao, canopyDao, dimensionsFenceDao);
  }
}