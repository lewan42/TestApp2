package android.print;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Landroid/print/PdfPrint;", "", "printAttributes", "Landroid/print/PrintAttributes;", "(Landroid/print/PrintAttributes;)V", "getOutputFile", "Landroid/os/ParcelFileDescriptor;", "path", "Ljava/io/File;", "fileName", "", "print", "", "printAdapter", "Landroid/print/PrintDocumentAdapter;", "callback", "Landroid/print/PdfPrint$CallbackPrint;", "CallbackPrint", "Companion", "app_release"})
public final class PdfPrint {
    private final android.print.PrintAttributes printAttributes = null;
    private static final java.lang.String TAG = null;
    public static final android.print.PdfPrint.Companion Companion = null;
    
    public final void print(@org.jetbrains.annotations.NotNull()
    android.print.PrintDocumentAdapter printAdapter, @org.jetbrains.annotations.NotNull()
    java.io.File path, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    android.print.PdfPrint.CallbackPrint callback) {
    }
    
    private final android.os.ParcelFileDescriptor getOutputFile(java.io.File path, java.lang.String fileName) {
        return null;
    }
    
    public PdfPrint(@org.jetbrains.annotations.NotNull()
    android.print.PrintAttributes printAttributes) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Landroid/print/PdfPrint$CallbackPrint;", "", "onFailure", "", "success", "path", "", "app_release"})
    public static abstract interface CallbackPrint {
        
        public abstract void success(@org.jetbrains.annotations.NotNull()
        java.lang.String path);
        
        public abstract void onFailure();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Landroid/print/PdfPrint$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}