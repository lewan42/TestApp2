// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.app.ui;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ViewModelFragment_MembersInjector<V extends ViewBinding> implements MembersInjector<ViewModelFragment<V>> {
  private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

  public ViewModelFragment_MembersInjector(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    this.viewModelFactoryProvider = viewModelFactoryProvider;
  }

  public static <V extends ViewBinding> MembersInjector<ViewModelFragment<V>> create(
      Provider<ViewModelProvider.Factory> viewModelFactoryProvider) {
    return new ViewModelFragment_MembersInjector<V>(viewModelFactoryProvider);
  }

  @Override
  public void injectMembers(ViewModelFragment<V> instance) {
    injectViewModelFactory(instance, viewModelFactoryProvider.get());
  }

  @InjectedFieldSignature("dev.fabula.android.app.ui.ViewModelFragment.viewModelFactory")
  public static <V extends ViewBinding> void injectViewModelFactory(ViewModelFragment<V> instance,
      ViewModelProvider.Factory viewModelFactory) {
    instance.viewModelFactory = viewModelFactory;
  }
}