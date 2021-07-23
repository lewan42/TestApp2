package dev.fabula.android.bosch.otg.file;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000ej\b\u0012\u0004\u0012\u00020\u0007`\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Ldev/fabula/android/bosch/otg/file/BoschFileOtg;", "Ldev/fabula/android/bosch/otg/data/source/BoschOtgDataSource;", "()V", "DIR_PATH", "", "getMeasurementsFromBoschDevice", "", "Ldev/fabula/android/bosch/otg/model/BoschOtgItemList;", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Ljava/io/File;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAllWithHeaderAsSequence", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_release"})
public final class BoschFileOtg implements dev.fabula.android.bosch.otg.data.source.BoschOtgDataSource {
    private final java.lang.String DIR_PATH = "/storage/usbotg/IMAGE/";
    
    private final java.util.ArrayList<dev.fabula.android.bosch.otg.model.BoschOtgItemList> readAllWithHeaderAsSequence(java.io.File file, android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMeasurementsFromBoschDevice(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> p2) {
        return null;
    }
    
    public BoschFileOtg() {
        super();
    }
}