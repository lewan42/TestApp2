// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.profile.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import dev.fabula.android.app.db.AppRoomDatabase;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.auth_old.AppAuth;
import dev.fabula.android.bluetooth.ui.BluetoothViewModel;
import dev.fabula.android.bluetooth.ui.BluetoothViewModel_Factory;
import dev.fabula.android.bridge.crossing.api.BridgeApi;
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao;
import dev.fabula.android.bridge.crossing.di.BridgeApiModule;
import dev.fabula.android.bridge.crossing.di.BridgeApiModule_GetBridgeApiFactory;
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule;
import dev.fabula.android.bridge.crossing.di.BridgeCrossingDaoModule_ProvidesBridgeDAOFactory;
import dev.fabula.android.canopy.api.CanopyApi;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.canopy.di.CanopyApiModule;
import dev.fabula.android.canopy.di.CanopyApiModule_GetCanopyApiFactory;
import dev.fabula.android.canopy.di.CanopyDaoModule;
import dev.fabula.android.canopy.di.CanopyDaoModule_ProvidesPlatformDAOFactory;
import dev.fabula.android.dimensions.fence.api.DimensionFenceAPI;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceApiModule;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceApiModule_GetDimensionApiFactory;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule;
import dev.fabula.android.dimensions.fence.di.DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory;
import dev.fabula.android.measurements.create.api.CreateMeasurementsApi;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.create.di.CreateMeasurementsApiModule;
import dev.fabula.android.measurements.create.di.CreateMeasurementsApiModule_GetMeasurementApiFactory;
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule;
import dev.fabula.android.measurements.create.di.CreateMeasurementsDaoModule_ProvidesCreateMeasurementsDAOFactory;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao;
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule;
import dev.fabula.android.measurements.type.di.MeasurementTypeDaoModule_ProvidesMeasurementTypeDAOFactory;
import dev.fabula.android.platform.api.PlatformApi;
import dev.fabula.android.platform.dao.PlatformDao;
import dev.fabula.android.platform.di.PlatformApiModule;
import dev.fabula.android.platform.di.PlatformApiModule_GetPlatformApiFactory;
import dev.fabula.android.platform.di.PlatformDaoModule;
import dev.fabula.android.platform.di.PlatformDaoModule_ProvidesPlatformDAOFactory;
import dev.fabula.android.profile.ui.ProfileFragment;
import dev.fabula.android.profile.ui.ProfileViewModel;
import dev.fabula.android.profile.ui.ProfileViewModel_Factory;
import dev.fabula.android.railway.dao.RailwayDao;
import dev.fabula.android.railway.di.RailwayDaoModule;
import dev.fabula.android.railway.di.RailwayDaoModule_ProvidesRailwayDAOFactory;
import dev.fabula.android.section.dao.RailwaySectionDao;
import dev.fabula.android.section.di.RailwaySectionDaoModule;
import dev.fabula.android.section.di.RailwaySectionDaoModule_ProvidesRailwaySectionDAOFactory;
import dev.fabula.android.station.peregon.api.StationApi;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import dev.fabula.android.station.peregon.di.StationApiModule;
import dev.fabula.android.station.peregon.di.StationApiModule_GetStationApiFactory;
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao;
import dev.fabula.android.station.peregon.di.StationPeregonModuleDao_ProvidesStationPeregonDAOFactory;
import dev.fabula.android.support.api.SupportApi;
import dev.fabula.android.support.dao.SupportDao;
import dev.fabula.android.support.di.SupportApiModule;
import dev.fabula.android.support.di.SupportApiModule_GetSupportApiFactory;
import dev.fabula.android.support.di.SupportDaoModule;
import dev.fabula.android.support.di.SupportDaoModule_ProvidesSupportDAOFactory;
import dev.fabula.android.synchronize.api.SyncApi;
import dev.fabula.android.synchronize.di.SyncApiModule;
import dev.fabula.android.synchronize.di.SyncApiModule_GetSyncApiFactory;
import dev.fabula.android.synchronize.repo.SyncRepository;
import dev.fabula.android.synchronize.repo.SyncRepository_Factory;
import dev.fabula.android.synchronize.ui.SyncViewModule;
import dev.fabula.android.synchronize.ui.SyncViewModule_Factory;
import dev.fabula.android.wire.carrier.api.CarrierWireApi;
import dev.fabula.android.wire.carrier.dao.CarrierWireDao;
import dev.fabula.android.wire.carrier.di.CarrierWireApiModule;
import dev.fabula.android.wire.carrier.di.CarrierWireApiModule_GetCarrierWireApiFactory;
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule;
import dev.fabula.android.wire.carrier.di.CarrierWireDaoModule_ProvidesCarrierWireDAOFactory;
import dev.fabula.android.wire.contact.api.ContactWireApi;
import dev.fabula.android.wire.contact.dao.ContactWireDao;
import dev.fabula.android.wire.contact.di.ContactWireApiModule;
import dev.fabula.android.wire.contact.di.ContactWireApiModule_GetCarrierWireApiFactory;
import dev.fabula.android.wire.contact.di.ContactWireDaoModule;
import dev.fabula.android.wire.contact.di.ContactWireDaoModule_ProvidesContactWireDAOFactory;
import java.util.Map;
import javax.inject.Provider;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerProfileComponent implements ProfileComponent {
  private Provider<AppAuth> provideAuthProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<SyncApi> getSyncApiProvider;

  private Provider<AppRoomDatabase> providesRoomDatabaseProvider;

  private Provider<RailwayDao> providesRailwayDAOProvider;

  private Provider<RailwaySectionDao> providesRailwaySectionDAOProvider;

  private Provider<StationPeregonDao> providesStationPeregonDAOProvider;

  private Provider<PlatformDao> providesPlatformDAOProvider;

  private Provider<SupportDao> providesSupportDAOProvider;

  private Provider<CreateMeasurementsDao> providesCreateMeasurementsDAOProvider;

  private Provider<BridgeCrossingDao> providesBridgeDAOProvider;

  private Provider<DimensionsFenceDao> providesDimensionsDAOProvider;

  private Provider<CanopyDao> providesPlatformDAOProvider2;

  private Provider<ContactWireDao> providesContactWireDAOProvider;

  private Provider<CarrierWireDao> providesCarrierWireDAOProvider;

  private Provider<StationApi> getStationApiProvider;

  private Provider<PlatformApi> getPlatformApiProvider;

  private Provider<CreateMeasurementsApi> getMeasurementApiProvider;

  private Provider<DimensionFenceAPI> getDimensionApiProvider;

  private Provider<ContactWireApi> getCarrierWireApiProvider;

  private Provider<CarrierWireApi> getCarrierWireApiProvider2;

  private Provider<MeasurementTypeDao> providesMeasurementTypeDAOProvider;

  private Provider<CanopyApi> getCanopyApiProvider;

  private Provider<SupportApi> getSupportApiProvider;

  private Provider<BridgeApi> getBridgeApiProvider;

  private Provider<SyncRepository> syncRepositoryProvider;

  private Provider<SyncViewModule> syncViewModuleProvider;

  private Provider<ProfileViewModel> profileViewModelProvider;

  private DaggerProfileComponent(SyncApiModule syncApiModuleParam,
      CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      CreateMeasurementsApiModule createMeasurementsApiModuleParam,
      CanopyApiModule canopyApiModuleParam, CanopyDaoModule canopyDaoModuleParam,
      StationPeregonModuleDao stationPeregonModuleDaoParam, StationApiModule stationApiModuleParam,
      ContactWireDaoModule contactWireDaoModuleParam,
      ContactWireApiModule contactWireApiModuleParam,
      CarrierWireDaoModule carrierWireDaoModuleParam,
      DimensionsFenceApiModule dimensionsFenceApiModuleParam,
      DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      CarrierWireApiModule carrierWireApiModuleParam, PlatformDaoModule platformDaoModuleParam,
      PlatformApiModule platformApiModuleParam, RailwayDaoModule railwayDaoModuleParam,
      RailwaySectionDaoModule railwaySectionDaoModuleParam, SupportDaoModule supportDaoModuleParam,
      BridgeCrossingDaoModule bridgeCrossingDaoModuleParam,
      MeasurementTypeDaoModule measurementTypeDaoModuleParam,
      SupportApiModule supportApiModuleParam, BridgeApiModule bridgeApiModuleParam,
      AppComponent appComponentParam) {

    initialize(syncApiModuleParam, createMeasurementsDaoModuleParam, createMeasurementsApiModuleParam, canopyApiModuleParam, canopyDaoModuleParam, stationPeregonModuleDaoParam, stationApiModuleParam, contactWireDaoModuleParam, contactWireApiModuleParam, carrierWireDaoModuleParam, dimensionsFenceApiModuleParam, dimensionsFenceDaoModuleParam, carrierWireApiModuleParam, platformDaoModuleParam, platformApiModuleParam, railwayDaoModuleParam, railwaySectionDaoModuleParam, supportDaoModuleParam, bridgeCrossingDaoModuleParam, measurementTypeDaoModuleParam, supportApiModuleParam, bridgeApiModuleParam, appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return MapBuilder.<Class<? extends ViewModel>, Provider<ViewModel>>newMapBuilder(3).put(SyncViewModule.class, (Provider) syncViewModuleProvider).put(ProfileViewModel.class, (Provider) profileViewModelProvider).put(BluetoothViewModel.class, (Provider) BluetoothViewModel_Factory.create()).build();
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final SyncApiModule syncApiModuleParam,
      final CreateMeasurementsDaoModule createMeasurementsDaoModuleParam,
      final CreateMeasurementsApiModule createMeasurementsApiModuleParam,
      final CanopyApiModule canopyApiModuleParam, final CanopyDaoModule canopyDaoModuleParam,
      final StationPeregonModuleDao stationPeregonModuleDaoParam,
      final StationApiModule stationApiModuleParam,
      final ContactWireDaoModule contactWireDaoModuleParam,
      final ContactWireApiModule contactWireApiModuleParam,
      final CarrierWireDaoModule carrierWireDaoModuleParam,
      final DimensionsFenceApiModule dimensionsFenceApiModuleParam,
      final DimensionsFenceDaoModule dimensionsFenceDaoModuleParam,
      final CarrierWireApiModule carrierWireApiModuleParam,
      final PlatformDaoModule platformDaoModuleParam,
      final PlatformApiModule platformApiModuleParam, final RailwayDaoModule railwayDaoModuleParam,
      final RailwaySectionDaoModule railwaySectionDaoModuleParam,
      final SupportDaoModule supportDaoModuleParam,
      final BridgeCrossingDaoModule bridgeCrossingDaoModuleParam,
      final MeasurementTypeDaoModule measurementTypeDaoModuleParam,
      final SupportApiModule supportApiModuleParam, final BridgeApiModule bridgeApiModuleParam,
      final AppComponent appComponentParam) {
    this.provideAuthProvider = SingleCheck.provider(new dev_fabula_android_app_di_AppComponent_provideAuth(appComponentParam));
    this.provideRetrofitProvider = new dev_fabula_android_app_di_AppComponent_provideRetrofit(appComponentParam);
    this.getSyncApiProvider = SyncApiModule_GetSyncApiFactory.create(syncApiModuleParam, provideRetrofitProvider);
    this.providesRoomDatabaseProvider = new dev_fabula_android_app_di_AppComponent_providesRoomDatabase(appComponentParam);
    this.providesRailwayDAOProvider = RailwayDaoModule_ProvidesRailwayDAOFactory.create(railwayDaoModuleParam, providesRoomDatabaseProvider);
    this.providesRailwaySectionDAOProvider = RailwaySectionDaoModule_ProvidesRailwaySectionDAOFactory.create(railwaySectionDaoModuleParam, providesRoomDatabaseProvider);
    this.providesStationPeregonDAOProvider = StationPeregonModuleDao_ProvidesStationPeregonDAOFactory.create(stationPeregonModuleDaoParam, providesRoomDatabaseProvider);
    this.providesPlatformDAOProvider = PlatformDaoModule_ProvidesPlatformDAOFactory.create(platformDaoModuleParam, providesRoomDatabaseProvider);
    this.providesSupportDAOProvider = SupportDaoModule_ProvidesSupportDAOFactory.create(supportDaoModuleParam, providesRoomDatabaseProvider);
    this.providesCreateMeasurementsDAOProvider = CreateMeasurementsDaoModule_ProvidesCreateMeasurementsDAOFactory.create(createMeasurementsDaoModuleParam, providesRoomDatabaseProvider);
    this.providesBridgeDAOProvider = BridgeCrossingDaoModule_ProvidesBridgeDAOFactory.create(bridgeCrossingDaoModuleParam, providesRoomDatabaseProvider);
    this.providesDimensionsDAOProvider = DimensionsFenceDaoModule_ProvidesDimensionsDAOFactory.create(dimensionsFenceDaoModuleParam, providesRoomDatabaseProvider);
    this.providesPlatformDAOProvider2 = CanopyDaoModule_ProvidesPlatformDAOFactory.create(canopyDaoModuleParam, providesRoomDatabaseProvider);
    this.providesContactWireDAOProvider = ContactWireDaoModule_ProvidesContactWireDAOFactory.create(contactWireDaoModuleParam, providesRoomDatabaseProvider);
    this.providesCarrierWireDAOProvider = CarrierWireDaoModule_ProvidesCarrierWireDAOFactory.create(carrierWireDaoModuleParam, providesRoomDatabaseProvider);
    this.getStationApiProvider = StationApiModule_GetStationApiFactory.create(stationApiModuleParam, provideRetrofitProvider);
    this.getPlatformApiProvider = PlatformApiModule_GetPlatformApiFactory.create(platformApiModuleParam, provideRetrofitProvider);
    this.getMeasurementApiProvider = CreateMeasurementsApiModule_GetMeasurementApiFactory.create(createMeasurementsApiModuleParam, provideRetrofitProvider);
    this.getDimensionApiProvider = DimensionsFenceApiModule_GetDimensionApiFactory.create(dimensionsFenceApiModuleParam, provideRetrofitProvider);
    this.getCarrierWireApiProvider = ContactWireApiModule_GetCarrierWireApiFactory.create(contactWireApiModuleParam, provideRetrofitProvider);
    this.getCarrierWireApiProvider2 = CarrierWireApiModule_GetCarrierWireApiFactory.create(carrierWireApiModuleParam, provideRetrofitProvider);
    this.providesMeasurementTypeDAOProvider = MeasurementTypeDaoModule_ProvidesMeasurementTypeDAOFactory.create(measurementTypeDaoModuleParam, providesRoomDatabaseProvider);
    this.getCanopyApiProvider = CanopyApiModule_GetCanopyApiFactory.create(canopyApiModuleParam, provideRetrofitProvider);
    this.getSupportApiProvider = SupportApiModule_GetSupportApiFactory.create(supportApiModuleParam, provideRetrofitProvider);
    this.getBridgeApiProvider = BridgeApiModule_GetBridgeApiFactory.create(bridgeApiModuleParam, provideRetrofitProvider);
    this.syncRepositoryProvider = SyncRepository_Factory.create(provideAuthProvider, getSyncApiProvider, providesRailwayDAOProvider, providesRailwaySectionDAOProvider, providesStationPeregonDAOProvider, providesPlatformDAOProvider, providesSupportDAOProvider, providesCreateMeasurementsDAOProvider, providesBridgeDAOProvider, providesDimensionsDAOProvider, providesPlatformDAOProvider2, providesContactWireDAOProvider, providesCarrierWireDAOProvider, getStationApiProvider, getPlatformApiProvider, getMeasurementApiProvider, getDimensionApiProvider, getCarrierWireApiProvider, getCarrierWireApiProvider2, providesMeasurementTypeDAOProvider, getCanopyApiProvider, getSupportApiProvider, getBridgeApiProvider);
    this.syncViewModuleProvider = SyncViewModule_Factory.create(syncRepositoryProvider);
    this.profileViewModelProvider = ProfileViewModel_Factory.create(syncRepositoryProvider, provideAuthProvider);
  }

  @Override
  public void inject(ProfileFragment fragment) {
    injectProfileFragment(fragment);
  }

  private ProfileFragment injectProfileFragment(ProfileFragment instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private SyncApiModule syncApiModule;

    private CreateMeasurementsDaoModule createMeasurementsDaoModule;

    private CreateMeasurementsApiModule createMeasurementsApiModule;

    private CanopyApiModule canopyApiModule;

    private CanopyDaoModule canopyDaoModule;

    private StationPeregonModuleDao stationPeregonModuleDao;

    private StationApiModule stationApiModule;

    private ContactWireDaoModule contactWireDaoModule;

    private ContactWireApiModule contactWireApiModule;

    private CarrierWireDaoModule carrierWireDaoModule;

    private DimensionsFenceApiModule dimensionsFenceApiModule;

    private DimensionsFenceDaoModule dimensionsFenceDaoModule;

    private CarrierWireApiModule carrierWireApiModule;

    private PlatformDaoModule platformDaoModule;

    private PlatformApiModule platformApiModule;

    private RailwayDaoModule railwayDaoModule;

    private RailwaySectionDaoModule railwaySectionDaoModule;

    private SupportDaoModule supportDaoModule;

    private BridgeCrossingDaoModule bridgeCrossingDaoModule;

    private MeasurementTypeDaoModule measurementTypeDaoModule;

    private SupportApiModule supportApiModule;

    private BridgeApiModule bridgeApiModule;

    private AppComponent appComponent;

    private Builder() {
    }

    public Builder syncApiModule(SyncApiModule syncApiModule) {
      this.syncApiModule = Preconditions.checkNotNull(syncApiModule);
      return this;
    }

    public Builder createMeasurementsDaoModule(
        CreateMeasurementsDaoModule createMeasurementsDaoModule) {
      this.createMeasurementsDaoModule = Preconditions.checkNotNull(createMeasurementsDaoModule);
      return this;
    }

    public Builder createMeasurementsApiModule(
        CreateMeasurementsApiModule createMeasurementsApiModule) {
      this.createMeasurementsApiModule = Preconditions.checkNotNull(createMeasurementsApiModule);
      return this;
    }

    public Builder canopyApiModule(CanopyApiModule canopyApiModule) {
      this.canopyApiModule = Preconditions.checkNotNull(canopyApiModule);
      return this;
    }

    public Builder canopyDaoModule(CanopyDaoModule canopyDaoModule) {
      this.canopyDaoModule = Preconditions.checkNotNull(canopyDaoModule);
      return this;
    }

    public Builder stationPeregonModuleDao(StationPeregonModuleDao stationPeregonModuleDao) {
      this.stationPeregonModuleDao = Preconditions.checkNotNull(stationPeregonModuleDao);
      return this;
    }

    public Builder stationApiModule(StationApiModule stationApiModule) {
      this.stationApiModule = Preconditions.checkNotNull(stationApiModule);
      return this;
    }

    public Builder contactWireDaoModule(ContactWireDaoModule contactWireDaoModule) {
      this.contactWireDaoModule = Preconditions.checkNotNull(contactWireDaoModule);
      return this;
    }

    public Builder contactWireApiModule(ContactWireApiModule contactWireApiModule) {
      this.contactWireApiModule = Preconditions.checkNotNull(contactWireApiModule);
      return this;
    }

    public Builder carrierWireDaoModule(CarrierWireDaoModule carrierWireDaoModule) {
      this.carrierWireDaoModule = Preconditions.checkNotNull(carrierWireDaoModule);
      return this;
    }

    public Builder dimensionsFenceApiModule(DimensionsFenceApiModule dimensionsFenceApiModule) {
      this.dimensionsFenceApiModule = Preconditions.checkNotNull(dimensionsFenceApiModule);
      return this;
    }

    public Builder dimensionsFenceDaoModule(DimensionsFenceDaoModule dimensionsFenceDaoModule) {
      this.dimensionsFenceDaoModule = Preconditions.checkNotNull(dimensionsFenceDaoModule);
      return this;
    }

    public Builder carrierWireApiModule(CarrierWireApiModule carrierWireApiModule) {
      this.carrierWireApiModule = Preconditions.checkNotNull(carrierWireApiModule);
      return this;
    }

    public Builder platformDaoModule(PlatformDaoModule platformDaoModule) {
      this.platformDaoModule = Preconditions.checkNotNull(platformDaoModule);
      return this;
    }

    public Builder platformApiModule(PlatformApiModule platformApiModule) {
      this.platformApiModule = Preconditions.checkNotNull(platformApiModule);
      return this;
    }

    public Builder railwayDaoModule(RailwayDaoModule railwayDaoModule) {
      this.railwayDaoModule = Preconditions.checkNotNull(railwayDaoModule);
      return this;
    }

    public Builder railwaySectionDaoModule(RailwaySectionDaoModule railwaySectionDaoModule) {
      this.railwaySectionDaoModule = Preconditions.checkNotNull(railwaySectionDaoModule);
      return this;
    }

    public Builder supportDaoModule(SupportDaoModule supportDaoModule) {
      this.supportDaoModule = Preconditions.checkNotNull(supportDaoModule);
      return this;
    }

    public Builder bridgeCrossingDaoModule(BridgeCrossingDaoModule bridgeCrossingDaoModule) {
      this.bridgeCrossingDaoModule = Preconditions.checkNotNull(bridgeCrossingDaoModule);
      return this;
    }

    public Builder measurementTypeDaoModule(MeasurementTypeDaoModule measurementTypeDaoModule) {
      this.measurementTypeDaoModule = Preconditions.checkNotNull(measurementTypeDaoModule);
      return this;
    }

    public Builder supportApiModule(SupportApiModule supportApiModule) {
      this.supportApiModule = Preconditions.checkNotNull(supportApiModule);
      return this;
    }

    public Builder bridgeApiModule(BridgeApiModule bridgeApiModule) {
      this.bridgeApiModule = Preconditions.checkNotNull(bridgeApiModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public ProfileComponent build() {
      if (syncApiModule == null) {
        this.syncApiModule = new SyncApiModule();
      }
      if (createMeasurementsDaoModule == null) {
        this.createMeasurementsDaoModule = new CreateMeasurementsDaoModule();
      }
      if (createMeasurementsApiModule == null) {
        this.createMeasurementsApiModule = new CreateMeasurementsApiModule();
      }
      if (canopyApiModule == null) {
        this.canopyApiModule = new CanopyApiModule();
      }
      if (canopyDaoModule == null) {
        this.canopyDaoModule = new CanopyDaoModule();
      }
      if (stationPeregonModuleDao == null) {
        this.stationPeregonModuleDao = new StationPeregonModuleDao();
      }
      if (stationApiModule == null) {
        this.stationApiModule = new StationApiModule();
      }
      if (contactWireDaoModule == null) {
        this.contactWireDaoModule = new ContactWireDaoModule();
      }
      if (contactWireApiModule == null) {
        this.contactWireApiModule = new ContactWireApiModule();
      }
      if (carrierWireDaoModule == null) {
        this.carrierWireDaoModule = new CarrierWireDaoModule();
      }
      if (dimensionsFenceApiModule == null) {
        this.dimensionsFenceApiModule = new DimensionsFenceApiModule();
      }
      if (dimensionsFenceDaoModule == null) {
        this.dimensionsFenceDaoModule = new DimensionsFenceDaoModule();
      }
      if (carrierWireApiModule == null) {
        this.carrierWireApiModule = new CarrierWireApiModule();
      }
      if (platformDaoModule == null) {
        this.platformDaoModule = new PlatformDaoModule();
      }
      if (platformApiModule == null) {
        this.platformApiModule = new PlatformApiModule();
      }
      if (railwayDaoModule == null) {
        this.railwayDaoModule = new RailwayDaoModule();
      }
      if (railwaySectionDaoModule == null) {
        this.railwaySectionDaoModule = new RailwaySectionDaoModule();
      }
      if (supportDaoModule == null) {
        this.supportDaoModule = new SupportDaoModule();
      }
      if (bridgeCrossingDaoModule == null) {
        this.bridgeCrossingDaoModule = new BridgeCrossingDaoModule();
      }
      if (measurementTypeDaoModule == null) {
        this.measurementTypeDaoModule = new MeasurementTypeDaoModule();
      }
      if (supportApiModule == null) {
        this.supportApiModule = new SupportApiModule();
      }
      if (bridgeApiModule == null) {
        this.bridgeApiModule = new BridgeApiModule();
      }
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerProfileComponent(syncApiModule, createMeasurementsDaoModule, createMeasurementsApiModule, canopyApiModule, canopyDaoModule, stationPeregonModuleDao, stationApiModule, contactWireDaoModule, contactWireApiModule, carrierWireDaoModule, dimensionsFenceApiModule, dimensionsFenceDaoModule, carrierWireApiModule, platformDaoModule, platformApiModule, railwayDaoModule, railwaySectionDaoModule, supportDaoModule, bridgeCrossingDaoModule, measurementTypeDaoModule, supportApiModule, bridgeApiModule, appComponent);
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

  private static class dev_fabula_android_app_di_AppComponent_provideRetrofit implements Provider<Retrofit> {
    private final AppComponent appComponent;

    dev_fabula_android_app_di_AppComponent_provideRetrofit(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Retrofit get() {
      return Preconditions.checkNotNull(appComponent.provideRetrofit(), "Cannot return null from a non-@Nullable component method");
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