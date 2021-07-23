package dev.fabula.android.section.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Ldev/fabula/android/section/ui/RailwaySectionViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/section/repo/RailwaySectionRepository;", "(Ldev/fabula/android/section/repo/RailwaySectionRepository;)V", "_railwaySections", "Landroidx/lifecycle/MutableLiveData;", "", "Ldev/fabula/android/section/model/RailwaySection;", "railwaySections", "Landroidx/lifecycle/LiveData;", "getRailwaySections", "()Landroidx/lifecycle/LiveData;", "", "uid_railway", "", "app_release"})
public final class RailwaySectionViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.section.model.RailwaySection>> _railwaySections = null;
    private final dev.fabula.android.section.repo.RailwaySectionRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.section.model.RailwaySection>> getRailwaySections() {
        return null;
    }
    
    public final void getRailwaySections(@org.jetbrains.annotations.NotNull()
    java.lang.String uid_railway) {
    }
    
    @javax.inject.Inject()
    public RailwaySectionViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.repo.RailwaySectionRepository repository) {
        super();
    }
}