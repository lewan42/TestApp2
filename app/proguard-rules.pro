# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

-keep class androidx.multidex.** { *; }

# ServiceLoader support
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}

# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

#-keep class kotlin.** { *; }
-keep class kotlin.reflect.** { *; }
-keep class kotlin.properties.** { *; }
-keep class kotlin.jvm.** { *; }
-keep class kotlin.Metadata { *; }

# TODO добавить детальные правила обфускации
-keep class dev.fabula.android.** { *; }

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#region Crashlytics

# To preserve the info Crashlytics needs for readable crash reports,
# add the following lines to your Proguard or Dexguard config file:
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# !!! To let Crashlytics automatically upload the ProGuard or DexGuard mapping file,
# remove this line from the config file, if it's present:
#-printmapping mapping.txt

# !!! For faster builds with ProGuard, exclude Crashlytics. Add the following lines to your ProGuard config file:
# -keep class com.crashlytics.** { *; }
# -dontwarn com.crashlytics.**

#endregion Crashlytics

#region Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
#endregion Glide

# libphonenumber for DexGuard only
# -keepresourcefiles assets/io/michaelrocks/libphonenumber/android/**

-keep class com.google.firebase.provider.FirebaseInitProvider { *; }