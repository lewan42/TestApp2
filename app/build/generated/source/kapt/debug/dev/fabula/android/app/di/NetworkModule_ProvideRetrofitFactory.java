// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.app.di;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<String> baseUrlProvider;

  private final Provider<OkHttpClient> clientProvider;

  private final Provider<Gson> converterProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<OkHttpClient> clientProvider,
      Provider<Gson> converterProvider) {
    this.module = module;
    this.baseUrlProvider = baseUrlProvider;
    this.clientProvider = clientProvider;
    this.converterProvider = converterProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, baseUrlProvider.get(), clientProvider.get(), converterProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<String> baseUrlProvider, Provider<OkHttpClient> clientProvider,
      Provider<Gson> converterProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, baseUrlProvider, clientProvider, converterProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, String baseUrl,
      OkHttpClient client, Gson converter) {
    return Preconditions.checkNotNull(instance.provideRetrofit(baseUrl, client, converter), "Cannot return null from a non-@Nullable @Provides method");
  }
}
