// Generated by Dagger (https://dagger.dev).
package dev.fabula.android.bluetooth.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Preconditions;
import dev.fabula.android.app.di.AppComponent;
import dev.fabula.android.app.di.ViewModelFactory;
import dev.fabula.android.app.ui.ViewModelFragment_MembersInjector;
import dev.fabula.android.bluetooth.ui.BluetoothFragment;
import dev.fabula.android.bluetooth.ui.BluetoothViewModel;
import dev.fabula.android.bluetooth.ui.BluetoothViewModel_Factory;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerBluetoothComponent implements BluetoothComponent {
  private DaggerBluetoothComponent(AppComponent appComponent) {

  }

  public static Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
      ) {
    return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(BluetoothViewModel.class, (Provider) BluetoothViewModel_Factory.create());
  }

  private ViewModelFactory getViewModelFactory() {
    return new ViewModelFactory(getMapOfClassOfAndProviderOfViewModel());
  }

  @Override
  public void inject(BluetoothFragment fragment) {
    injectBluetoothFragment(fragment);
  }

  private BluetoothFragment injectBluetoothFragment(BluetoothFragment instance) {
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

    public BluetoothComponent build() {
      Preconditions.checkBuilderRequirement(appComponent, AppComponent.class);
      return new DaggerBluetoothComponent(appComponent);
    }
  }
}