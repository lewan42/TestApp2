// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.dimensions.fence.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository;
import dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository_Factory;
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceFragment;
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceViewModule;
import dev.fabula.android.dimensions.fence.ui.DimensionsFenceViewModule_Factory;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule;
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule_ProvidesCreateMeasurementsDAOFactory;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao;
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule;
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule_ProvidesMeasurementTypeDAOFactory;
import dev.fabula.android.platform.dao.PlatformDao;
import dev.fabula.android.platform.di.PlatformDaoModule;
import dev.fabula.android.platform.di.PlatformDaoModule_ProvidesPlatformDAOFactory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerDimensionsFenceComponent implements DimensionsFenceComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<PlatformDao> providesPlatformDAOProvider;

  private Provider<DimensionsFenceDao> providesDimensionsDAOProvider;

  private Provider<CreateMeasurementsDao> providesCreateMeasurementsDAOProvider;

  private Provider<MeasurementTypeDao> providesMeasurementTypeDAOProvider;

  private Provider<DimensionsFenceRepository> dimensionsFenceRepositoryProvider;

  private Provider<DimensionsFenceViewModule> dimensionsFenceViewModuleProvider;

  private DaggerDimensionsFenceComponent(PlatformDaoModule platformDaoModuleParam,
      DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      MeasurementTypeDaoModule measurementTypeDaoModuleParam, AppComponent appComponentParam) {

    initialize(platformDaoModuleParam, dimensionsFenceDaoModuleParam, createMeasurementsDaoModuleParam, measurementTypeDaoModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(DimensionsFenceViewModule.class, (Provider) dimensionsFenceViewModuleProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final PlatformDaoModule platformDaoModuleParam,
      final DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      final CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      final MeasurementTypeDaoModule measurementTypeDaoModuleParam,
      final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesPlatformDAOProvider = PlatformDaoModule_ProvidesPlatformDAOFactory.create(platformDaoModuleParam, providesRoomDatabaseProvider);
    this.providesDimensionsDAOProvider = DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory.create(dimensionsFenceDaoModuleParam, providesRoomDatabaseProvider);
    this.providesCreateMeasurementsDAOProvider = CreateMeasurementsDaoModule_ProvidesCreateMeasurementsDAOFactory.create(createMeasurementsDaoModuleParam, providesRoomDatabaseProvider);
    this.providesMeasurementTypeDAOProvider = MeasurementTypeDaoModule_ProvidesMeasurementTypeDAOFactory.create(measurementTypeDaoModuleParam, providesRoomDatabaseProvider);
    this.dimensionsFenceRepositoryProvider = DimensionsFenceRepository_Factory.create(providesPlatformDAOProvider, providesDimensionsDAOProvider, providesCreateMeasurementsDAOProvider, providesMeasurementTypeDAOProvider);
    this.dimensionsFenceViewModuleProvider = DimensionsFenceViewModule_Factory.create(dimensionsFenceRepositoryProvider);
  }

  @Override
  public void inject(DimensionsFenceFragment fragment) {
    injectDimensionsFenceFragment(fragment);
  }

  private DimensionsFenceFragment injectDimensionsFenceFragment(DimensionsFenceFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private PlatformDaoModule platformDaoModule;

    private DimensionsFenceDaoModule dimensionsFenceDaoModule;

    private CreateMeasurementsDaoModule createMeasurementsDaoModule;

    private MeasurementTypeDaoModule measurementTypeDaoModule;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder platformDaoModule(PlatformDaoModule platformDaoModule) {
      this.platformDaoModule = Preconditions.checkNotNull(platformDaoModule);
      return this;
    }

    public Builder dimensionsFenceDaoModule(DimensionsFenceDaoModule dimensionsFenceDaoModule) {
      this.dimensionsFenceDaoModule = Preconditions.checkNotNull(dimensionsFenceDaoModule);
      return this;
    }

    public Builder createMeasurementsDaoModule(
        CreateMeasurementsDaoModule createMeasurementsDaoModule) {
      this.createMeasurementsDaoModule = Preconditions.checkNotNull(createMeasurementsDaoModule);
      return this;
    }

    public Builder measurementTypeDaoModule(MeasurementTypeDaoModule measurementTypeDaoModule) {
      this.measurementTypeDaoModule = Preconditions.checkNotNull(measurementTypeDaoModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public DimensionsFenceComponent build() {
      if (platformDaoModule == null) {
        this.platformDaoModule = new PlatformDaoModule();
      }
      if (dimensionsFenceDaoModule == null) {
        this.dimensionsFenceDaoModule = new DimensionsFenceDaoModule();
      }
      if (createMeasurementsDaoModule == null) {
        this.createMeasurementsDaoModule = new CreateMeasurementsDaoModule();
      }
      if (measurementTypeDaoModule == null) {
        this.measurementTypeDaoModule = new MeasurementTypeDaoModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerDimensionsFenceComponent(platformDaoModule, dimensionsFenceDaoModule, createMeasurementsDaoModule, measurementTypeDaoModule, appComponent);
    }
  }

  private static class dev_fabula_android_app_di_AppComponent_providesRoomDatabase implements Provider<AppRoomDatabase> {
    private final AppComponent appComponent;

    dev_fabula_android_app_di_AppComponent_providesRoomDatabase(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public AppRoomDatabase get() {
      return Preconditions.checkNotNull(appComponent.providesRoomDatabase(), "Cannot return null from a non-@Nullable component method");
    }
  }
}