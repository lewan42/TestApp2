// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.splash;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import dev.fabula.android.auth_old.AppAuth;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SplashFragment_MembersInjector implements MembersInjector<SplashFragment> {
  private final Provider<AppAuth> authProvider;

  public SplashFragment_MembersInjector(Provider<AppAuth> authProvider) {
    this.authProvider = authProvider;
  }

  public static MembersInjector<SplashFragment> create(Provider<AppAuth> authProvider) {
    return new SplashFragment_MembersInjector(authProvider);
  }

  @Override
  public void injectMembers(SplashFragment instance) {
    injectAuth(instance, authProvider.get());
  }

  @InjectedFieldSignature("dev.fabula.android.splash.SplashFragment.auth")
  public static void injectAuth(SplashFragment instance, AppAuth auth) {
    instance.auth = auth;
  }
}