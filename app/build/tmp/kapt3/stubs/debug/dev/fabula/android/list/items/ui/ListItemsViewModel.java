package dev.fabula.android.list.items.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\u0011\u001a\u00020\u000eJ\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\u0013\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\u0015\u001a\u00020\u000eJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Ldev/fabula/android/list/items/ui/ListItemsViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/list/items/repo/ListItemsRepository;", "auth", "Ldev/fabula/android/auth_old/AppAuth;", "(Ldev/fabula/android/list/items/repo/ListItemsRepository;Ldev/fabula/android/auth_old/AppAuth;)V", "items", "Landroidx/lifecycle/MutableLiveData;", "", "Ldev/fabula/android/list/items/model/ListItem;", "fetchBridgesOfPlatform", "Landroidx/lifecycle/LiveData;", "uidPlatform", "", "fetchDimensionFenceOfPlatform", "fetchPlatformsOfRailwaySection", "uidStationOrPeregon", "fetchSupportOfRailwaySection", "uidSupport", "fetchSupportsOfBridge", "uidBridge", "fetchSupportsOfPlatform", "app_debug"})
public final class ListItemsViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> items = null;
    private final dev.fabula.android.list.items.repo.ListItemsRepository repository = null;
    private final dev.fabula.android.auth_old.AppAuth auth = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchPlatformsOfRailwaySection(@org.jetbrains.annotations.NotNull()
    java.lang.String uidStationOrPeregon) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchSupportOfRailwaySection(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchDimensionFenceOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchBridgesOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchSupportsOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.list.items.model.ListItem>> fetchSupportsOfBridge(@org.jetbrains.annotations.NotNull()
    java.lang.String uidBridge) {
        return null;
    }
    
    @javax.inject.Inject()
    public ListItemsViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.list.items.repo.ListItemsRepository repository, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.auth_old.AppAuth auth) {
        super();
    }
}