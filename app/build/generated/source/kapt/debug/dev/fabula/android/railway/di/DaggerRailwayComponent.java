// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.railway.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.railway.dao.RailwayDao;
import dev.fabula.android.railway.repo.RailwayRepository;
import dev.fabula.android.railway.repo.RailwayRepository_Factory;
import dev.fabula.android.railway.ui.RailwayFragment;
import dev.fabula.android.railway.ui.RailwayViewModel;
import dev.fabula.android.railway.ui.RailwayViewModel_Factory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerRailwayComponent implements RailwayComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<RailwayDao> providesRailwayDAOProvider;

  private Provider<RailwayRepository> railwayRepositoryProvider;

  private Provider<RailwayViewModel> railwayViewModelProvider;

  private DaggerRailwayComponent(RailwayDaoModule railwayDaoModuleParam,
      AppComponent appComponentParam) {

    initialize(railwayDaoModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(RailwayViewModel.class, (Provider) railwayViewModelProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final RailwayDaoModule railwayDaoModuleParam,
      final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesRailwayDAOProvider = RailwayDaoModule_ProvidesRailwayDAOFactory.create(railwayDaoModuleParam, providesRoomDatabaseProvider);
    this.railwayRepositoryProvider = RailwayRepository_Factory.create(providesRailwayDAOProvider);
    this.railwayViewModelProvider = RailwayViewModel_Factory.create(railwayRepositoryProvider);
  }

  @Override
  public void inject(RailwayFragment fragment) {
    injectRailwayFragment(fragment);
  }

  private RailwayFragment injectRailwayFragment(RailwayFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private RailwayDaoModule railwayDaoModule;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder railwayDaoModule(RailwayDaoModule railwayDaoModule) {
      this.railwayDaoModule = Preconditions.checkNotNull(railwayDaoModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public RailwayComponent build() {
      if (railwayDaoModule == null) {
        this.railwayDaoModule = new RailwayDaoModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerRailwayComponent(railwayDaoModule, appComponent);
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
