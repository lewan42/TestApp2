package android.print;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Landroid/print/PdfView;", "", "()V", "REQUEST_CODE", "", "createWebPdfJob", "", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "directory", "Ljava/io/File;", "fileName", "", "callback", "Landroid/print/PdfView$Callback;", "fileChooser", "path", "openPdfFile", "Callback", "app_debug"})
public final class PdfView {
    private static final int REQUEST_CODE = 101;
    public static final android.print.PdfView INSTANCE = null;
    
    /**
     * convert webview content into to pdf file
     * @param activity pass the current activity context
     * @param webView webview
     * @param directory directory path where pdf file will be saved
     * @param fileName name of the pdf file.
     */
    public final void createWebPdfJob(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.io.File directory, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    android.print.PdfView.Callback callback) {
    }
    
    /**
     * create alert dialog to open the pdf file
     * @param activity pass the current activity context
     * @param title  to show the heading of the alert dialog
     * @param message  to show on the message area.
     * @param path file path create on storage directory
     */
    public final void openPdfFile(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String path) {
    }
    
    /**
     * @param activity pass the current activity context
     * @param path storage full path
     */
    private final void fileChooser(android.app.Activity activity, java.lang.String path) {
    }
    
    private PdfView() {
        super();
    }
    
    /**
     * callback interface to get the result back after created pdf file
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Landroid/print/PdfView$Callback;", "", "failure", "", "success", "path", "", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void success(@org.jetbrains.annotations.NotNull()
        java.lang.String path);
        
        public abstract void failure();
    }
}