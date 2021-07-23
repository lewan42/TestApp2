// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.bridge.crossing.repo;

import dagger.internal.Factory;
import dev.fabula.android.auth_old.AppAuth;
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao;
import dev.fabula.android.platform.dao.PlatformDao;
import dev.fabula.android.support.dao.SupportDao;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BridgeRepository_Factory implements Factory<BridgeRepository> {
  private final Provider<PlatformDao> platformDaoProvider;

  private final Provider<SupportDao> supportDaoProvider;

  private final Provider<BridgeCrossingDao> bridgeCrossingDaoProvider;

  private final Provider<AppAuth> authProvider;

  public BridgeRepository_Factory(Provider<PlatformDao> platformDaoProvider,
      Provider<SupportDao> supportDaoProvider,
      Provider<BridgeCrossingDao> bridgeCrossingDaoProvider, Provider<AppAuth> authProvider) {
    this.platformDaoProvider = platformDaoProvider;
    this.supportDaoProvider = supportDaoProvider;
    this.bridgeCrossingDaoProvider = bridgeCrossingDaoProvider;
    this.authProvider = authProvider;
  }

  @Override
  public BridgeRepository get() {
    return newInstance(platformDaoProvider.get(), supportDaoProvider.get(), bridgeCrossingDaoProvider.get(), authProvider.get());
  }

  public static BridgeRepository_Factory create(Provider<PlatformDao> platformDaoProvider,
      Provider<SupportDao> supportDaoProvider,
      Provider<BridgeCrossingDao> bridgeCrossingDaoProvider, Provider<AppAuth> authProvider) {
    return new BridgeRepository_Factory(platformDaoProvider, supportDaoProvider, bridgeCrossingDaoProvider, authProvider);
  }

  public static BridgeRepository newInstance(PlatformDao platformDao, SupportDao supportDao,
      BridgeCrossingDao bridgeCrossingDao, AppAuth auth) {
    return new BridgeRepository(platformDao, supportDao, bridgeCrossingDao, auth);
  }
}