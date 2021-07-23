package dev.fabula.android.support.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JJ\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\b\u00102\u001a\u0004\u0018\u00010\u00142\b\u00103\u001a\u0004\u0018\u00010\u0014J\u000e\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\u0014J\u000e\u00106\u001a\u00020+2\u0006\u00105\u001a\u00020\u0014J\u000e\u00107\u001a\u00020+2\u0006\u00105\u001a\u00020\u0014J\u000e\u00108\u001a\u00020+2\u0006\u00105\u001a\u00020\u0014J\u0016\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014J\u0016\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020+2\u0006\u00105\u001a\u00020\u0014JL\u0010(\u001a\u00020+2\u0006\u00105\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00142\b\u00102\u001a\u0004\u0018\u00010\u00142\b\u00103\u001a\u0004\u0018\u00010\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0019R\u001f\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010\u0019R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00178F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0019\u00a8\u0006@"}, d2 = {"Ldev/fabula/android/support/ui/SupportViewModule;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/support/repo/SupportRepository;", "(Ldev/fabula/android/support/repo/SupportRepository;)V", "_carrierWireForHeight", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/app/ui/Event;", "Ldev/fabula/android/wire/carrier/model/CarrierWire;", "_carrierWireForZigzag", "_contactWireForZigzag", "Ldev/fabula/android/wire/contact/model/ContactWire;", "_createContactWireForHeight", "_createIfNotExist", "", "_measurement", "Ldev/fabula/android/measurements/model/Measurement;", "_support", "Ldev/fabula/android/support/model/Support;", "_uidSupportOfPlatform", "", "_updateSupport", "carrierWireForHeight", "Landroidx/lifecycle/LiveData;", "getCarrierWireForHeight", "()Landroidx/lifecycle/LiveData;", "carrierWireForZigzag", "getCarrierWireForZigzag", "contactWireForZigzag", "getContactWireForZigzag", "createContactWireForHeight", "getCreateContactWireForHeight", "createIfNotExist", "getCreateIfNotExist", "measurement", "getMeasurement", "support", "getSupport", "uidCreatedSupportOfPlatform", "getUidCreatedSupportOfPlatform", "updateSupport", "getUpdateSupport", "createSupport", "", "uidPlatform", "contentType", "number", "kmWay", "wayNumber", "picket", "photo1", "photo2", "getCarrierWireForHeightBySupport", "uidSupport", "getCarrierWireForZigzagBySupport", "getContactWireForHeightBySupport", "getContactWireForZigzagBySupport", "getMeasurementByParentCarrierWire", "uidCarrierWire", "uidTypeMeasurement", "getMeasurementByParentContactWire", "uidContactWire", "getSupportById", "comment", "app_release"})
public final class SupportViewModule extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _updateSupport = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> _createIfNotExist = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.support.model.Support>> _support = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.contact.model.ContactWire>> _createContactWireForHeight = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.contact.model.ContactWire>> _contactWireForZigzag = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.carrier.model.CarrierWire>> _carrierWireForHeight = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.carrier.model.CarrierWire>> _carrierWireForZigzag = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.measurements.model.Measurement>> _measurement = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<java.lang.String>> _uidSupportOfPlatform = null;
    private final dev.fabula.android.support.repo.SupportRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getUpdateSupport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.Boolean>> getCreateIfNotExist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.support.model.Support>> getSupport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.contact.model.ContactWire>> getCreateContactWireForHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.contact.model.ContactWire>> getContactWireForZigzag() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.carrier.model.CarrierWire>> getCarrierWireForHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.wire.carrier.model.CarrierWire>> getCarrierWireForZigzag() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.measurements.model.Measurement>> getMeasurement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<java.lang.String>> getUidCreatedSupportOfPlatform() {
        return null;
    }
    
    public final void getContactWireForHeightBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
    }
    
    public final void getContactWireForZigzagBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
    }
    
    public final void getCarrierWireForHeightBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
    }
    
    public final void getCarrierWireForZigzagBySupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
    }
    
    public final void getSupportById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport) {
    }
    
    public final void getMeasurementByParentContactWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uidContactWire, @org.jetbrains.annotations.NotNull()
    java.lang.String uidTypeMeasurement) {
    }
    
    public final void getMeasurementByParentCarrierWire(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCarrierWire, @org.jetbrains.annotations.NotNull()
    java.lang.String uidTypeMeasurement) {
    }
    
    public final void createSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform, @org.jetbrains.annotations.NotNull()
    java.lang.String contentType, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String wayNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2) {
    }
    
    public final void updateSupport(@org.jetbrains.annotations.NotNull()
    java.lang.String uidSupport, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String kmWay, @org.jetbrains.annotations.NotNull()
    java.lang.String wayNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String picket, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.lang.String photo1, @org.jetbrains.annotations.Nullable()
    java.lang.String photo2) {
    }
    
    @javax.inject.Inject()
    public SupportViewModule(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.repo.SupportRepository repository) {
        super();
    }
}