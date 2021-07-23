// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.auth_old;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAuthComponent implements AuthComponent {
  private final AppComponent appComponent;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<AppAuth> provideAuthProvider;

  private Provider<AuthViewModel> authViewModelProvider;

  private DaggerAuthComponent(AppComponent appComponentParam) {
    this.appComponent = appComponentParam;
    initialize(appComponentParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(AuthViewModel.class, (Provider) authViewModelProvider);
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final AppComponent appComponentParam) {
    this.provideRetrofitProvider = new dev_fabula_android_app_di_AppComponent_provideRetrofit(appComponentParam);
    this.provideAuthProvider = SingleCheck.provider(new dev_fabula_android_app_di_AppComponent_provideAuth(appComponentParam));
    this.authViewModelProvider = AuthViewModel_Factory.create(provideRetrofitProvider, provideAuthProvider);
  }

  @Override
  public void inject(AuthFragmentPhone fragment) {
    injectAuthFragmentPhone(fragment);
  }

  @Override
  public void inject(AuthFragmentCode fragment) {
    injectAuthFragmentCode(fragment);
  }

  private AuthFragmentPhone injectAuthFragmentPhone(AuthFragmentPhone instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    AuthFragmentPhone_MembersInjector.injectPhoneUtil(instance, Preconditions.checkNotNull(appComponent.providePhoneNumberUtil(), "Cannot return null from a non-@Nullable component method"));
    return instance;
  }

  private AuthFragmentCode injectAuthFragmentCode(AuthFragmentCode instance) {
    ViewModelFragment_MembersInjector.injectViewModelFactory(instance, getViewModelFactory());
    return instance;
  }

  public static final class Builder {
    private AppComponent appComponent;

    private Builder() {
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }

    public AuthComponent build() {
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerAuthComponent(appComponent);
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