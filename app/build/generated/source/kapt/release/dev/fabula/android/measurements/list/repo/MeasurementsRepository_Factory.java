// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.measurements.list.repo;

import dagger.internal.Factory;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MeasurementsRepository_Factory implements Factory<MeasurementsRepository> {
  private final Provider<CreateMeasurementsDao> createMeasurementsDaoProvider;

  private final Provider<CanopyDao> canopyDaoProvider;

  private final Provider<MeasurementTypeDao> typeMeasurementsDaoProvider;

  public MeasurementsRepository_Factory(
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<CanopyDao> canopyDaoProvider,
      Provider<MeasurementTypeDao> typeMeasurementsDaoProvider) {
    this.createMeasurementsDaoProvider = createMeasurementsDaoProvider;
    this.canopyDaoProvider = canopyDaoProvider;
    this.typeMeasurementsDaoProvider = typeMeasurementsDaoProvider;
  }

  @Override
  public MeasurementsRepository get() {
    return newInstance(createMeasurementsDaoProvider.get(), canopyDaoProvider.get(), typeMeasurementsDaoProvider.get());
  }

  public static MeasurementsRepository_Factory create(
      Provider<CreateMeasurementsDao> createMeasurementsDaoProvider,
      Provider<CanopyDao> canopyDaoProvider,
      Provider<MeasurementTypeDao> typeMeasurementsDaoProvider) {
    return new MeasurementsRepository_Factory(createMeasurementsDaoProvider, canopyDaoProvider, typeMeasurementsDaoProvider);
  }

  public static MeasurementsRepository newInstance(CreateMeasurementsDao createMeasurementsDao,
      CanopyDao canopyDao, MeasurementTypeDao typeMeasurementsDao) {
    return new MeasurementsRepository(createMeasurementsDao, canopyDao, typeMeasurementsDao);
  }
}
