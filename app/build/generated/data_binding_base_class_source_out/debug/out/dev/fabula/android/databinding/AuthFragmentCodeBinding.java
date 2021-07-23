// Generated by view binder compiler. Do not edit!
package dev.fabula.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.santalu.maskara.widget.MaskEditText;
import dev.fabula.android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AuthFragmentCodeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Barrier barrierLogo;

  @NonNull
  public final View bottomBar;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final Button btnRetry;

  @NonNull
  public final Guideline guidelineEnd;

  @NonNull
  public final Guideline guidelineStart;

  @NonNull
  public final Guideline guidelineTop;

  @NonNull
  public final ImageView imgAuthLogo;

  @NonNull
  public final MaskEditText inputNumber;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final TextView retryTimer;

  @NonNull
  public final TextView textAuthTitle;

  private AuthFragmentCodeBinding(@NonNull ConstraintLayout rootView, @NonNull Barrier barrierLogo,
      @NonNull View bottomBar, @NonNull Button btnNext, @NonNull Button btnRetry,
      @NonNull Guideline guidelineEnd, @NonNull Guideline guidelineStart,
      @NonNull Guideline guidelineTop, @NonNull ImageView imgAuthLogo,
      @NonNull MaskEditText inputNumber, @NonNull ProgressBar progress,
      @NonNull TextView retryTimer, @NonNull TextView textAuthTitle) {
    this.rootView = rootView;
    this.barrierLogo = barrierLogo;
    this.bottomBar = bottomBar;
    this.btnNext = btnNext;
    this.btnRetry = btnRetry;
    this.guidelineEnd = guidelineEnd;
    this.guidelineStart = guidelineStart;
    this.guidelineTop = guidelineTop;
    this.imgAuthLogo = imgAuthLogo;
    this.inputNumber = inputNumber;
    this.progress = progress;
    this.retryTimer = retryTimer;
    this.textAuthTitle = textAuthTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AuthFragmentCodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AuthFragmentCodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.auth_fragment_code, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AuthFragmentCodeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.barrier_logo;
      Barrier barrierLogo = rootView.findViewById(id);
      if (barrierLogo == null) {
        break missingId;
      }

      id = R.id.bottom_bar;
      View bottomBar = rootView.findViewById(id);
      if (bottomBar == null) {
        break missingId;
      }

      id = R.id.btn_next;
      Button btnNext = rootView.findViewById(id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btn_retry;
      Button btnRetry = rootView.findViewById(id);
      if (btnRetry == null) {
        break missingId;
      }

      id = R.id.guideline_end;
      Guideline guidelineEnd = rootView.findViewById(id);
      if (guidelineEnd == null) {
        break missingId;
      }

      id = R.id.guideline_start;
      Guideline guidelineStart = rootView.findViewById(id);
      if (guidelineStart == null) {
        break missingId;
      }

      id = R.id.guideline_top;
      Guideline guidelineTop = rootView.findViewById(id);
      if (guidelineTop == null) {
        break missingId;
      }

      id = R.id.img_auth_logo;
      ImageView imgAuthLogo = rootView.findViewById(id);
      if (imgAuthLogo == null) {
        break missingId;
      }

      id = R.id.input_number;
      MaskEditText inputNumber = rootView.findViewById(id);
      if (inputNumber == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = rootView.findViewById(id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.retry_timer;
      TextView retryTimer = rootView.findViewById(id);
      if (retryTimer == null) {
        break missingId;
      }

      id = R.id.text_auth_title;
      TextView textAuthTitle = rootView.findViewById(id);
      if (textAuthTitle == null) {
        break missingId;
      }

      return new AuthFragmentCodeBinding((ConstraintLayout) rootView, barrierLogo, bottomBar,
          btnNext, btnRetry, guidelineEnd, guidelineStart, guidelineTop, imgAuthLogo, inputNumber,
          progress, retryTimer, textAuthTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
