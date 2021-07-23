// Generated by view binder compiler. Do not edit!
package dev.fabula.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import dev.fabula.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileFragmentBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnAddPhoto;

  @NonNull
  public final AppCompatImageButton btnBack;

  @NonNull
  public final Button btnBluetoothBosch;

  @NonNull
  public final Button btnExit;

  @NonNull
  public final Button btnSync;

  @NonNull
  public final TextView connectedDevice;

  @NonNull
  public final TextView profile;

  @NonNull
  public final ProgressBar progressSync;

  @NonNull
  public final ScrollView scroll;

  @NonNull
  public final TextView tvConnectedDeviceName;

  @NonNull
  public final TextView tvEmail;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvVersion;

  private ProfileFragmentBinding(@NonNull ScrollView rootView, @NonNull Button btnAddPhoto,
      @NonNull AppCompatImageButton btnBack, @NonNull Button btnBluetoothBosch,
      @NonNull Button btnExit, @NonNull Button btnSync, @NonNull TextView connectedDevice,
      @NonNull TextView profile, @NonNull ProgressBar progressSync, @NonNull ScrollView scroll,
      @NonNull TextView tvConnectedDeviceName, @NonNull TextView tvEmail, @NonNull TextView tvName,
      @NonNull TextView tvVersion) {
    this.rootView = rootView;
    this.btnAddPhoto = btnAddPhoto;
    this.btnBack = btnBack;
    this.btnBluetoothBosch = btnBluetoothBosch;
    this.btnExit = btnExit;
    this.btnSync = btnSync;
    this.connectedDevice = connectedDevice;
    this.profile = profile;
    this.progressSync = progressSync;
    this.scroll = scroll;
    this.tvConnectedDeviceName = tvConnectedDeviceName;
    this.tvEmail = tvEmail;
    this.tvName = tvName;
    this.tvVersion = tvVersion;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_photo;
      Button btnAddPhoto = rootView.findViewById(id);
      if (btnAddPhoto == null) {
        break missingId;
      }

      id = R.id.btn_back;
      AppCompatImageButton btnBack = rootView.findViewById(id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.btn_bluetooth_bosch;
      Button btnBluetoothBosch = rootView.findViewById(id);
      if (btnBluetoothBosch == null) {
        break missingId;
      }

      id = R.id.btn_exit;
      Button btnExit = rootView.findViewById(id);
      if (btnExit == null) {
        break missingId;
      }

      id = R.id.btn_sync;
      Button btnSync = rootView.findViewById(id);
      if (btnSync == null) {
        break missingId;
      }

      id = R.id.connected_device;
      TextView connectedDevice = rootView.findViewById(id);
      if (connectedDevice == null) {
        break missingId;
      }

      id = R.id.profile;
      TextView profile = rootView.findViewById(id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.progress_sync;
      ProgressBar progressSync = rootView.findViewById(id);
      if (progressSync == null) {
        break missingId;
      }

      ScrollView scroll = (ScrollView) rootView;

      id = R.id.tv_connected_device_name;
      TextView tvConnectedDeviceName = rootView.findViewById(id);
      if (tvConnectedDeviceName == null) {
        break missingId;
      }

      id = R.id.tv_email;
      TextView tvEmail = rootView.findViewById(id);
      if (tvEmail == null) {
        break missingId;
      }

      id = R.id.tv_name;
      TextView tvName = rootView.findViewById(id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_version;
      TextView tvVersion = rootView.findViewById(id);
      if (tvVersion == null) {
        break missingId;
      }

      return new ProfileFragmentBinding((ScrollView) rootView, btnAddPhoto, btnBack,
          btnBluetoothBosch, btnExit, btnSync, connectedDevice, profile, progressSync, scroll,
          tvConnectedDeviceName, tvEmail, tvName, tvVersion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}