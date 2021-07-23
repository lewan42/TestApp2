// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.screen.measurements.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository;
import dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository_Factory;
import dev.fabula.android.screen.measurements.ui.ScreenMeasurementsFragment;
import dev.fabula.android.screen.measurements.ui.ScreenMeasurementsViewModule;
import dev.fabula.android.screen.measurements.ui.ScreenMeasurementsViewModule_Factory;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao;
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao_ProvidesStationPeregonDAOFactory;
import dev.fabula.android.support.dao.SupportDao;
import dev.fabula.android.support.di.SupportDaoModule;
import dev.fabula.android.support.di.SupportDaoModule_ProvidesSupportDAOFactory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerScreenMeasurementsComponent implements ScreenMeasurementsComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<StationPeregonDao> providesStationPeregonDAOProvider;

  private Provider<SupportDao> providesSupportDAOProvider;

  private Provider<ScreenMeasurementsRepository> screenMeasurementsRepositoryProvider;

  private Provider<ScreenMeasurementsViewModule> screenMeasurementsViewModuleProvider;

  private DaggerScreenMeasurementsComponent(StationPeregonModuleDao stationPeregonModuleDaoParam,
      SupportDaoModule supportDaoModuleParam, AppComponent appComponentParam) {

    initialize(stationPeregonModuleDaoParam, supportDaoModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(ScreenMeasurementsViewModule.class, (Provider) screenMeasurementsViewModuleProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final StationPeregonModuleDao stationPeregonModuleDaoParam,
      final SupportDaoModule supportDaoModuleParam, final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesStationPeregonDAOProvider = StationPeregonModuleDao_ProvidesStationPeregonDAOFactory.create(stationPeregonModuleDaoParam, providesRoomDatabaseProvider);
    this.providesSupportDAOProvider = SupportDaoModule_ProvidesSupportDAOFactory.create(supportDaoModuleParam, providesRoomDatabaseProvider);
    this.screenMeasurementsRepositoryProvider = ScreenMeasurementsRepository_Factory.create(providesStationPeregonDAOProvider, providesSupportDAOProvider);
    this.screenMeasurementsViewModuleProvider = ScreenMeasurementsViewModule_Factory.create(screenMeasurementsRepositoryProvider);
  }

  @Override
  public void inject(ScreenMeasurementsFragment fragment) {
    injectScreenMeasurementsFragment(fragment);
  }

  private ScreenMeasurementsFragment injectScreenMeasurementsFragment(
      ScreenMeasurementsFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private StationPeregonModuleDao stationPeregonModuleDao;

    private SupportDaoModule supportDaoModule;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder stationPeregonModuleDao(StationPeregonModuleDao stationPeregonModuleDao) {
      this.stationPeregonModuleDao = Preconditions.checkNotNull(stationPeregonModuleDao);
      return this;
    }

    public Builder supportDaoModule(SupportDaoModule supportDaoModule) {
      this.supportDaoModule = Preconditions.checkNotNull(supportDaoModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public ScreenMeasurementsComponent build() {
      if (stationPeregonModuleDao == null) {
        this.stationPeregonModuleDao = new StationPeregonModuleDao();
      }
      if (supportDaoModule == null) {
        this.supportDaoModule = new SupportDaoModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerScreenMeasurementsComponent(stationPeregonModuleDao, supportDaoModule, appComponent);
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