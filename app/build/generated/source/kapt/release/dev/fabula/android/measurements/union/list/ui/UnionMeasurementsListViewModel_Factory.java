// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.measurements.union.list.ui;

import dagger.internal.Factory;
import dev.fabula.android.measurements.union.list.repo.UnionMeasurementsRepository;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UnionMeasurementsListViewModel_Factory implements Factory<UnionMeasurementsListViewModel> {
  private final Provider<UnionMeasurementsRepository> repositoryProvider;

  public UnionMeasurementsListViewModel_Factory(
      Provider<UnionMeasurementsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public UnionMeasurementsListViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static UnionMeasurementsListViewModel_Factory create(
      Provider<UnionMeasurementsRepository> repositoryProvider) {
    return new UnionMeasurementsListViewModel_Factory(repositoryProvider);
  }

  public static UnionMeasurementsListViewModel newInstance(UnionMeasurementsRepository repository) {
    return new UnionMeasurementsListViewModel(repository);
  }
}
