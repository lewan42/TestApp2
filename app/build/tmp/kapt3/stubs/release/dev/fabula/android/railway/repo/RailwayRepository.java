package dev.fabula.android.railway.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Ldev/fabula/android/railway/repo/RailwayRepository;", "", "railwayDao", "Ldev/fabula/android/railway/dao/RailwayDao;", "(Ldev/fabula/android/railway/dao/RailwayDao;)V", "allRailways", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/fabula/android/railway/model/Railway;", "getAllRailways", "()Lkotlinx/coroutines/flow/Flow;", "app_release"})
public final class RailwayRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.railway.model.Railway>> allRailways = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<dev.fabula.android.railway.model.Railway>> getAllRailways() {
        return null;
    }
    
    @javax.inject.Inject()
    public RailwayRepository(@org.jetbrains.annotations.NotNull()
    dev.fabula.android.railway.dao.RailwayDao railwayDao) {
        super();
    }
}