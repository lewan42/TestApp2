// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.station.peregon.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import dev.fabula.android.station.peregon.repo.StationPeregonRepository;
import dev.fabula.android.station.peregon.repo.StationPeregonRepository_Factory;
import dev.fabula.android.station.peregon.ui.StationPeregonFragment;
import dev.fabula.android.station.peregon.ui.StationPeregonViewModule;
import dev.fabula.android.station.peregon.ui.StationPeregonViewModule_Factory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerStationPeregonComponent implements StationPeregonComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<StationPeregonDao> providesStationPeregonDAOProvider;

  private Provider<StationPeregonRepository> stationPeregonRepositoryProvider;

  private Provider<StationPeregonViewModule> stationPeregonViewModuleProvider;

  private DaggerStationPeregonComponent(StationPeregonModuleDao stationPeregonModuleDaoParam,
      AppComponent appComponentParam) {

    initialize(stationPeregonModuleDaoParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(StationPeregonViewModule.class, (Provider) stationPeregonViewModuleProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final StationPeregonModuleDao stationPeregonModuleDaoParam,
      final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesStationPeregonDAOProvider = StationPeregonModuleDao_ProvidesStationPeregonDAOFactory.create(stationPeregonModuleDaoParam, providesRoomDatabaseProvider);
    this.stationPeregonRepositoryProvider = StationPeregonRepository_Factory.create(providesStationPeregonDAOProvider);
    this.stationPeregonViewModuleProvider = StationPeregonViewModule_Factory.create(stationPeregonRepositoryProvider);
  }

  @Override
  public void inject(StationPeregonFragment fragment) {
    injectStationPeregonFragment(fragment);
  }

  private StationPeregonFragment injectStationPeregonFragment(StationPeregonFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private StationPeregonModuleDao stationPeregonModuleDao;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder stationPeregonModuleDao(StationPeregonModuleDao stationPeregonModuleDao) {
      this.stationPeregonModuleDao = Preconditions.checkNotNull(stationPeregonModuleDao);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public StationPeregonComponent build() {
      if (stationPeregonModuleDao == null) {
        this.stationPeregonModuleDao = new StationPeregonModuleDao();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerStationPeregonComponent(stationPeregonModuleDao, appComponent);
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
