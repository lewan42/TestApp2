package dev.fabula.android.report.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u0002082\u0006\u00109\u001a\u00020:J\u000e\u00100\u001a\u0002082\u0006\u0010<\u001a\u00020:J\u000e\u0010=\u001a\u0002082\u0006\u00109\u001a\u00020:J\u000e\u0010>\u001a\u0002082\u0006\u00109\u001a\u00020:J\u000e\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020:R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001b0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001b0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00190(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0(8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010*R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001b0(8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010*R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001b0(8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010*R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020!0(8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020#0(8F\u00a2\u0006\u0006\u001a\u0004\b4\u0010*R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0(8F\u00a2\u0006\u0006\u001a\u0004\b6\u0010*\u00a8\u0006A"}, d2 = {"Ldev/fabula/android/report/ui/ReportViewModel;", "Ldev/fabula/android/app/ui/BaseViewModel;", "repository", "Ldev/fabula/android/railway/repo/RailwayRepository;", "repositorySection", "Ldev/fabula/android/section/repo/RailwaySectionRepository;", "repositorySupport", "Ldev/fabula/android/support/repo/SupportRepository;", "repositoryScreenMeasurements", "Ldev/fabula/android/screen/measurements/repo/ScreenMeasurementsRepository;", "repositoryReport", "Ldev/fabula/android/report/repo/ReportRepository;", "repositoryPlatform", "Ldev/fabula/android/platform/repo/PlatformRepository;", "repositoryMeasurement", "Ldev/fabula/android/measurements/list/repo/MeasurementsRepository;", "repositoryStation", "Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;", "repositoryDimensionsFence", "Ldev/fabula/android/dimensions/fence/repo/DimensionsFenceRepository;", "repositoryCanopy", "Ldev/fabula/android/canopy/repo/CanopyRepository;", "(Ldev/fabula/android/railway/repo/RailwayRepository;Ldev/fabula/android/section/repo/RailwaySectionRepository;Ldev/fabula/android/support/repo/SupportRepository;Ldev/fabula/android/screen/measurements/repo/ScreenMeasurementsRepository;Ldev/fabula/android/report/repo/ReportRepository;Ldev/fabula/android/platform/repo/PlatformRepository;Ldev/fabula/android/measurements/list/repo/MeasurementsRepository;Ldev/fabula/android/station/peregon/repo/StationPeregonRepository;Ldev/fabula/android/dimensions/fence/repo/DimensionsFenceRepository;Ldev/fabula/android/canopy/repo/CanopyRepository;)V", "_canopy", "Landroidx/lifecycle/MutableLiveData;", "Ldev/fabula/android/canopy/model/Canopy;", "_dimensionFence", "", "Ldev/fabula/android/dimensions/fence/model/DimensionsWithMeasure;", "_measurementPlatforms", "Ldev/fabula/android/measurements/model/Measurement;", "_measurementsOfCanopy", "_platform", "Ldev/fabula/android/platform/model/Platform;", "_station", "Ldev/fabula/android/station/peregon/model/StationPeregon;", "_support", "Ldev/fabula/android/app/ui/Event;", "Ldev/fabula/android/support/model/Support;", "canopy", "Landroidx/lifecycle/LiveData;", "getCanopy", "()Landroidx/lifecycle/LiveData;", "dimensionFence", "getDimensionFence", "measurementPlatforms", "getMeasurementPlatforms", "measurementsOfCanopy", "getMeasurementsOfCanopy", "platform", "getPlatform", "station", "getStation", "support", "getSupport", "getCanopyOfPlatform", "", "uidPlatform", "", "getDimensionList", "uidCanopy", "getMeasurementsOfPlatform", "getPlatformById", "getStationPeregon", "uid", "app_debug"})
public final class ReportViewModel extends dev.fabula.android.app.ui.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> _measurementPlatforms = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.platform.model.Platform> _platform = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.station.peregon.model.StationPeregon> _station = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure>> _dimensionFence = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.canopy.model.Canopy> _canopy = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> _measurementsOfCanopy = null;
    private final androidx.lifecycle.MutableLiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.support.model.Support>> _support = null;
    private final dev.fabula.android.railway.repo.RailwayRepository repository = null;
    private final dev.fabula.android.section.repo.RailwaySectionRepository repositorySection = null;
    private final dev.fabula.android.support.repo.SupportRepository repositorySupport = null;
    private final dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository repositoryScreenMeasurements = null;
    private final dev.fabula.android.report.repo.ReportRepository repositoryReport = null;
    private final dev.fabula.android.platform.repo.PlatformRepository repositoryPlatform = null;
    private final dev.fabula.android.measurements.list.repo.MeasurementsRepository repositoryMeasurement = null;
    private final dev.fabula.android.station.peregon.repo.StationPeregonRepository repositoryStation = null;
    private final dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository repositoryDimensionsFence = null;
    private final dev.fabula.android.canopy.repo.CanopyRepository repositoryCanopy = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> getMeasurementPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.platform.model.Platform> getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.station.peregon.model.StationPeregon> getStation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.dimensions.fence.model.DimensionsWithMeasure>> getDimensionFence() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.canopy.model.Canopy> getCanopy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<dev.fabula.android.measurements.model.Measurement>> getMeasurementsOfCanopy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<dev.fabula.android.app.ui.Event<dev.fabula.android.support.model.Support>> getSupport() {
        return null;
    }
    
    public final void getDimensionList(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void getMeasurementsOfCanopy(@org.jetbrains.annotations.NotNull()
    java.lang.String uidCanopy) {
    }
    
    public final void getCanopyOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void getStationPeregon(@org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
    }
    
    public final void getMeasurementsOfPlatform(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    public final void getPlatformById(@org.jetbrains.annotations.NotNull()
    java.lang.String uidPlatform) {
    }
    
    @javax.inject.Inject()
    public ReportViewModel(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.repo.RailwayRepository repository, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.section.repo.RailwaySectionRepository repositorySection, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.support.repo.SupportRepository repositorySupport, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.screen.measurements.repo.ScreenMeasurementsRepository repositoryScreenMeasurements, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.report.repo.ReportRepository repositoryReport, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.platform.repo.PlatformRepository repositoryPlatform, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.measurements.list.repo.MeasurementsRepository repositoryMeasurement, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.station.peregon.repo.StationPeregonRepository repositoryStation, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.dimensions.fence.repo.DimensionsFenceRepository repositoryDimensionsFence, @org.jetbrains.annotations.NotNull()
    dev.fabula.android.canopy.repo.CanopyRepository repositoryCanopy) {
        super();
    }
}