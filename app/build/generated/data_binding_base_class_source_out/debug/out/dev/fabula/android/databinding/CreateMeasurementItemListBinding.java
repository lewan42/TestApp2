// Generated by view binder compiler. Do not edit!
package dev.fabula.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import dev.fabula.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CreateMeasurementItemListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView height;

  @NonNull
  public final ImageButton info;

  @NonNull
  public final TextView length;

  @NonNull
  public final TextView numberMeasure;

  @NonNull
  public final TextView resultMeasurementText;

  @NonNull
  public final TextView typeMeasurementText;

  private CreateMeasurementItemListBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView height, @NonNull ImageButton info, @NonNull TextView length,
      @NonNull TextView numberMeasure, @NonNull TextView resultMeasurementText,
      @NonNull TextView typeMeasurementText) {
    this.rootView = rootView;
    this.height = height;
    this.info = info;
    this.length = length;
    this.numberMeasure = numberMeasure;
    this.resultMeasurementText = resultMeasurementText;
    this.typeMeasurementText = typeMeasurementText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CreateMeasurementItemListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CreateMeasurementItemListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.create_measurement_item_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CreateMeasurementItemListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.height;
      TextView height = rootView.findViewById(id);
      if (height == null) {
        break missingId;
      }

      id = R.id.info;
      ImageButton info = rootView.findViewById(id);
      if (info == null) {
        break missingId;
      }

      id = R.id.length;
      TextView length = rootView.findViewById(id);
      if (length == null) {
        break missingId;
      }

      id = R.id.number_measure;
      TextView numberMeasure = rootView.findViewById(id);
      if (numberMeasure == null) {
        break missingId;
      }

      id = R.id.result_measurement_text;
      TextView resultMeasurementText = rootView.findViewById(id);
      if (resultMeasurementText == null) {
        break missingId;
      }

      id = R.id.type_measurement_text;
      TextView typeMeasurementText = rootView.findViewById(id);
      if (typeMeasurementText == null) {
        break missingId;
      }

      return new CreateMeasurementItemListBinding((ConstraintLayout) rootView, height, info, length,
          numberMeasure, resultMeasurementText, typeMeasurementText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
