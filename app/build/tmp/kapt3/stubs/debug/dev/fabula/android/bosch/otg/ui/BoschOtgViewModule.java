package dev.fabula.android.bosch.otg.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Ldev/fabula/android/bosch/otg/ui/BoschOtgViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/bosch/otg/repo/BoschOtgRepository;", "(Ldev/fabula/android/bosch/otg/repo/BoschOtgRepository;)V", "_data", "Landroidx/lifecycle/MutableLiveData;", "", "Ldev/fabula/android/bosch/otg/model/BoschOtgItemList;", "data", "Landroidx/lifecycle/LiveData;", "getData", "()Landroidx/lifecycle/LiveData;", "getDataFromBoschDevice", "", "file", "Ljava/io/File;", "context", "Landroid/content/Context;", "app_debug"})
public final class BoschOtgViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> _data = null;
    private final dev.fabula.android.bosch.otg.repo.BoschOtgRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.bosch.otg.model.BoschOtgItemList>> getData() {
        return null;
    }
    
    public final void getDataFromBoschDevice(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @javax.inject.Inject()
    public BoschOtgViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.bosch.otg.repo.BoschOtgRepository repository) {
        super();
    }
}