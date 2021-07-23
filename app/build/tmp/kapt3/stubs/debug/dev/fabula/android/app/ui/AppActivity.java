package dev.fabula.android.app.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u000fH\u0002J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0018H\u0014J\b\u0010!\u001a\u00020\u000fH\u0014J\b\u0010\"\u001a\u00020\u000fH\u0014J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Ldev/fabula/android/app/ui/AppActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CAMERA_REQUEST_CODE", "", "adapter", "Landroid/nfc/NfcAdapter;", "cameraViewModel", "Ldev/fabula/android/camera/CameraViewModel;", "getCameraViewModel", "()Ldev/fabula/android/camera/CameraViewModel;", "cameraViewModel$delegate", "Lkotlin/Lazy;", "mIMAGE", "alertDialog", "", "disableNfcForegroundDispatch", "enableNfcForegroundDispatch", "initNfcAdapter", "listenActionPhoto", "onActivityResult", "requestCode", "resultCode", "imageReturnedIntent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onPause", "onResume", "onSupportNavigateUp", "", "app_debug"})
public final class AppActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int CAMERA_REQUEST_CODE = 100;
    private final kotlin.Lazy cameraViewModel$delegate = null;
    private int mIMAGE = 0;
    private android.nfc.NfcAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    private final dev.fabula.android.camera.CameraViewModel getCameraViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void listenActionPhoto() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent imageReturnedIntent) {
    }
    
    private final void alertDialog() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    public final void initNfcAdapter() {
    }
    
    public final void enableNfcForegroundDispatch() {
    }
    
    public final void disableNfcForegroundDispatch() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    public AppActivity() {
        super();
    }
}