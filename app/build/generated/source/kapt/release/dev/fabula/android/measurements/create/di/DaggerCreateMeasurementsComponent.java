// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.measurements.create.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.canopy.di.CanopyDaoModule;
import dev.fabula.android.canopy.di.CanopyDaoModule_ProvidesPlatformDAOFactory;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.create.repo.CreateMeasurementsRepository;
import dev.fabula.android.measurements.create.repo.CreateMeasurementsRepository_Factory;
import dev.fabula.android.measurements.create.ui.CreateMeasurementsFragment;
import dev.fabula.android.measurements.create.ui.CreateMeasurementsViewModel;
import dev.fabula.android.measurements.create.ui.CreateMeasurementsViewModel_Factory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerCreateMeasurementsComponent implements CreateMeasurementsComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<CreateMeasurementsDao> providesCreateMeasurementsDAOProvider;

  private Provider<CanopyDao> providesPlatformDAOProvider;

  private Provider<DimensionsFenceDao> providesDimensionsDAOProvider;

  private Provider<CreateMeasurementsRepository> createMeasurementsRepositoryProvider;

  private Provider<CreateMeasurementsViewModel> createMeasurementsViewModelProvider;

  private DaggerCreateMeasurementsComponent(
      CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      CanopyDaoModule canopyDaoModuleParam, DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      AppComponent appComponentParam) {

    initialize(createMeasurementsDaoModuleParam, canopyDaoModuleParam, dimensionsFenceDaoModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(CreateMeasurementsViewModel.class, (Provider) createMeasurementsViewModelProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      final CanopyDaoModule canopyDaoModuleParam,
      final DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesCreateMeasurementsDAOProvider = CreateMeasurementsDaoModule_ProvidesCreateMeasurementsDAOFactory.create(createMeasurementsDaoModuleParam, providesRoomDatabaseProvider);
    this.providesPlatformDAOProvider = CanopyDaoModule_ProvidesPlatformDAOFactory.create(canopyDaoModuleParam, providesRoomDatabaseProvider);
    this.providesDimensionsDAOProvider = DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory.create(dimensionsFenceDaoModuleParam, providesRoomDatabaseProvider);
    this.createMeasurementsRepositoryProvider = CreateMeasurementsRepository_Factory.create(providesCreateMeasurementsDAOProvider, providesPlatformDAOProvider, providesDimensionsDAOProvider);
    this.createMeasurementsViewModelProvider = CreateMeasurementsViewModel_Factory.create(createMeasurementsRepositoryProvider);
  }

  @Override
  public void inject(CreateMeasurementsFragment fragment) {
    injectCreateMeasurementsFragment(fragment);
  }

  private CreateMeasurementsFragment injectCreateMeasurementsFragment(
      CreateMeasurementsFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private CreateMeasurementsDaoModule createMeasurementsDaoModule;

    private CanopyDaoModule canopyDaoModule;

    private DimensionsFenceDaoModule dimensionsFenceDaoModule;

    private AppComponent appComponent;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder createMeasurementsApiModule(
        CreateMeasurementsApiModule createMeasurementsApiModule) {
      Preconditions.checkNotNull(createMeasurementsApiModule);
      return this;
    }

    public Builder createMeasurementsDaoModule(
        CreateMeasurementsDaoModule createMeasurementsDaoModule) {
      this.createMeasurementsDaoModule = Preconditions.checkNotNull(createMeasurementsDaoModule);
      return this;
    }

    public Builder canopyDaoModule(CanopyDaoModule canopyDaoModule) {
      this.canopyDaoModule = Preconditions.checkNotNull(canopyDaoModule);
      return this;
    }

    public Builder dimensionsFenceDaoModule(DimensionsFenceDaoModule dimensionsFenceDaoModule) {
      this.dimensionsFenceDaoModule = Preconditions.checkNotNull(dimensionsFenceDaoModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public CreateMeasurementsComponent build() {
      if (createMeasurementsDaoModule == null) {
        this.createMeasurementsDaoModule = new CreateMeasurementsDaoModule();
      }
      if (canopyDaoModule == null) {
        this.canopyDaoModule = new CanopyDaoModule();
      }
      if (dimensionsFenceDaoModule == null) {
        this.dimensionsFenceDaoModule = new DimensionsFenceDaoModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerCreateMeasurementsComponent(createMeasurementsDaoModule, canopyDaoModule, dimensionsFenceDaoModule, appComponent);
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