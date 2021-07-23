// Generated by view binder compiler. Do not edit!
package dev.fabula.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dev.fabula.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogHeightWidthNormsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText height;

  @NonNull
  public final TextInputLayout heightContainer;

  @NonNull
  public final TextInputEditText width;

  @NonNull
  public final TextInputLayout widthContainer;

  private DialogHeightWidthNormsBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputEditText height, @NonNull TextInputLayout heightContainer,
      @NonNull TextInputEditText width, @NonNull TextInputLayout widthContainer) {
    this.rootView = rootView;
    this.height = height;
    this.heightContainer = heightContainer;
    this.width = width;
    this.widthContainer = widthContainer;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogHeightWidthNormsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogHeightWidthNormsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_height_width_norms, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogHeightWidthNormsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.height;
      TextInputEditText height = rootView.findViewById(id);
      if (height == null) {
        break missingId;
      }

      id = R.id.height_container;
      TextInputLayout heightContainer = rootView.findViewById(id);
      if (heightContainer == null) {
        break missingId;
      }

      id = R.id.width;
      TextInputEditText width = rootView.findViewById(id);
      if (width == null) {
        break missingId;
      }

      id = R.id.width_container;
      TextInputLayout widthContainer = rootView.findViewById(id);
      if (widthContainer == null) {
        break missingId;
      }

      return new DialogHeightWidthNormsBinding((ConstraintLayout) rootView, height, heightContainer,
          width, widthContainer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}