package dev.fabula.android.app.ui;

import java.lang.System;

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000bJ\u000b\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Ldev/fabula/android/app/ui/Event;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "hasBeenHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getContentIfNotHandled", "", "handleContent", "Lkotlin/Function1;", "peekContent", "()Ljava/lang/Object;", "app_debug"})
public final class Event<T extends java.lang.Object> {
    private final java.util.concurrent.atomic.AtomicBoolean hasBeenHandled = null;
    private final T content = null;
    
    /**
     * Returns the content and prevents its use again.
     */
    public final void getContentIfNotHandled(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> handleContent) {
    }
    
    /**
     * Returns the content, even if it's already been handled.
     */
    public final T peekContent() {
        return null;
    }
    
    public Event(T content) {
        super();
    }
}