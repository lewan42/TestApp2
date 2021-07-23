package dev.fabula.android.camera;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006$"}, d2 = {"Ldev/fabula/android/camera/CameraViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "()V", "_takePhotoAction", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "Landroid/graphics/Bitmap;", "_takePhotoAction2", "actionPhoto", "", "getActionPhoto", "()Landroidx/lifecycle/MutableLiveData;", "actionPhoto2", "getActionPhoto2", "takePhotoAction", "Landroidx/lifecycle/LiveData;", "getTakePhotoAction", "()Landroidx/lifecycle/LiveData;", "takePhotoAction2", "getTakePhotoAction2", "convertImage", "", "bitmap", "image", "Landroidx/appcompat/widget/AppCompatImageButton;", "res", "", "context", "Landroid/content/Context;", "encodedImage", "insertBitmapOnImageView", "", "imageView", "setPhotoActivityResult", "bitmapPhoto", "setPhotoActivityResult2", "app_release"})
public final class CameraViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> actionPhoto = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> actionPhoto2 = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<android.graphics.Bitmap>> _takePhotoAction = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<android.graphics.Bitmap>> _takePhotoAction2 = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getActionPhoto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getActionPhoto2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<android.graphics.Bitmap>> getTakePhotoAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<android.graphics.Bitmap>> getTakePhotoAction2() {
        return null;
    }
    
    public final void setPhotoActivityResult(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmapPhoto) {
    }
    
    public final void setPhotoActivityResult2(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmapPhoto) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap convertImage(@org.jetbrains.annotations.Nullable()
    java.lang.String encodedImage) {
        return null;
    }
    
    public final void insertBitmapOnImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatImageButton imageView) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String convertImage(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatImageButton image) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String convertImage(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String convertImage(int res, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public CameraViewModel() {
        super();
    }
}