// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.support.ui;

import dagger.internal.Factory;
import dev.fabula.android.support.repo.SupportRepository;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SupportViewModule_Factory implements Factory<SupportViewModule> {
  private final Provider<SupportRepository> repositoryProvider;

  public SupportViewModule_Factory(Provider<SupportRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SupportViewModule get() {
    return newInstance(repositoryProvider.get());
  }

  public static SupportViewModule_Factory create(Provider<SupportRepository> repositoryProvider) {
    return new SupportViewModule_Factory(repositoryProvider);
  }

  public static SupportViewModule newInstance(SupportRepository repository) {
    return new SupportViewModule(repository);
  }
}
