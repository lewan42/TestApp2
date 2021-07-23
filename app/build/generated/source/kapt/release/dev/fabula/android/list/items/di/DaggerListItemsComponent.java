// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.list.items.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.auth_old.AppAuth;
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao;
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule;
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule_ProvidesBridgeDAOFactory;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.canopy.di.CanopyDaoModule;
import dev.fabula.android.canopy.di.CanopyDaoModule_ProvidesPlatformDAOFactory;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory;
import dev.fabula.android.list.items.repo.ListItemsRepository;
import dev.fabula.android.list.items.repo.ListItemsRepository_Factory;
import dev.fabula.android.list.items.ui.ListItemsFragment;
import dev.fabula.android.list.items.ui.ListItemsViewModel;
import dev.fabula.android.list.items.ui.ListItemsViewModel_Factory;
import dev.fabula.android.platform.dao.PlatformDao;
import dev.fabula.android.platform.di.PlatformDaoModule;
import dev.fabula.android.platform.di.PlatformDaoModule_ProvidesPlatformDAOFactory;
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
public final class DaggerListItemsComponent implements ListItemsComponent {
  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<PlatformDao> providesPlatformDAOProvider;

  private Provider<BridgeCrossingDao> providesBridgeDAOProvider;

  private Provider<SupportDao> providesSupportDAOProvider;

  private Provider<DimensionsFenceDao> providesDimensionsDAOProvider;

  private Provider<CanopyDao> providesPlatformDAOProvider2;

  private Provider<ListItemsRepository> listItemsRepositoryProvider;

  private Provider<AppAuth> provideAuthProvider;

  private Provider<ListItemsViewModel> listItemsViewModelProvider;

  private DaggerListItemsComponent(PlatformDaoModule platformDaoModuleParam,
      BridgeCrossingDaoModule bridgeCrossingDaoModuleParam, SupportDaoModule supportDaoModuleParam,
      DimensionsFenceDaoModule dimensionsFenceDaoModuleParam, CanopyDaoModule canopyDaoModuleParam,
      AppComponent appComponentParam) {

    initialize(platformDaoModuleParam, bridgeCrossingDaoModuleParam, supportDaoModuleParam, dimensionsFenceDaoModuleParam, canopyDaoModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(ListItemsViewModel.class, (Provider) listItemsViewModelProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final PlatformDaoModule platformDaoModuleParam,
      final BridgeCrossingDaoModule bridgeCrossingDaoModuleParam,
      final SupportDaoModule supportDaoModuleParam,
      final DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      final CanopyDaoModule canopyDaoModuleParam, final AppComponent appComponentParam) {
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesPlatformDAOProvider = PlatformDaoModule_ProvidesPlatformDAOFactory.create(platformDaoModuleParam, providesRoomDatabaseProvider);
    this.providesBridgeDAOProvider = BridgeCrossingDaoModule_ProvidesBridgeDAOFactory.create(bridgeCrossingDaoModuleParam, providesRoomDatabaseProvider);
    this.providesSupportDAOProvider = SupportDaoModule_ProvidesSupportDAOFactory.create(supportDaoModuleParam, providesRoomDatabaseProvider);
    this.providesDimensionsDAOProvider = DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory.create(dimensionsFenceDaoModuleParam, providesRoomDatabaseProvider);
    this.providesPlatformDAOProvider2 = CanopyDaoModule_ProvidesPlatformDAOFactory.create(canopyDaoModuleParam, providesRoomDatabaseProvider);
    this.listItemsRepositoryProvider = ListItemsRepository_Factory.create(providesPlatformDAOProvider, providesBridgeDAOProvider, providesSupportDAOProvider, providesDimensionsDAOProvider, providesPlatformDAOProvider2);
    this.provideAuthProvider = SingleCheck.provider(new dev_fabula_android_app_di_AppComponent_provideAuth(appComponentParam));
    this.listItemsViewModelProvider = ListItemsViewModel_Factory.create(listItemsRepositoryProvider, provideAuthProvider);
  }

  @Override
  public void inject(ListItemsFragment fragment) {
    injectListItemsFragment(fragment);
  }

  private ListItemsFragment injectListItemsFragment(ListItemsFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private PlatformDaoModule platformDaoModule;

    private BridgeCrossingDaoModule bridgeCrossingDaoModule;

    private SupportDaoModule supportDaoModule;

    private DimensionsFenceDaoModule dimensionsFenceDaoModule;

    private CanopyDaoModule canopyDaoModule;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder platformDaoModule(PlatformDaoModule platformDaoModule) {
      this.platformDaoModule = Preconditions.checkNotNull(platformDaoModule);
      return this;
    }

    public Builder bridgeCrossingDaoModule(BridgeCrossingDaoModule bridgeCrossingDaoModule) {
      this.bridgeCrossingDaoModule = Preconditions.checkNotNull(bridgeCrossingDaoModule);
      return this;
    }

    public Builder supportDaoModule(SupportDaoModule supportDaoModule) {
      this.supportDaoModule = Preconditions.checkNotNull(supportDaoModule);
      return this;
    }

    public Builder dimensionsFenceDaoModule(DimensionsFenceDaoModule dimensionsFenceDaoModule) {
      this.dimensionsFenceDaoModule = Preconditions.checkNotNull(dimensionsFenceDaoModule);
      return this;
    }

    public Builder canopyDaoModule(CanopyDaoModule canopyDaoModule) {
      this.canopyDaoModule = Preconditions.checkNotNull(canopyDaoModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public ListItemsComponent build() {
      if (platformDaoModule == null) {
        this.platformDaoModule = new PlatformDaoModule();
      }
      if (bridgeCrossingDaoModule == null) {
        this.bridgeCrossingDaoModule = new BridgeCrossingDaoModule();
      }
      if (supportDaoModule == null) {
        this.supportDaoModule = new SupportDaoModule();
      }
      if (dimensionsFenceDaoModule == null) {
        this.dimensionsFenceDaoModule = new DimensionsFenceDaoModule();
      }
      if (canopyDaoModule == null) {
        this.canopyDaoModule = new CanopyDaoModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerListItemsComponent(platformDaoModule, bridgeCrossingDaoModule, supportDaoModule, dimensionsFenceDaoModule, canopyDaoModule, appComponent);
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

  private static class dev_fabula_android_app_di_AppComponent_provideAuth implements Provider<AppAuth> {
    private final AppComponent appComponent;

    dev_fabula_android_app_di_AppComponent_provideAuth(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public AppAuth get() {
      return Preconditions.checkNotNull(appComponent.provideAuth(), "Cannot return null from a non-@Nullable component method");
    }
  }
}
