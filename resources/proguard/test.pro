# Proguard rules that are applied to your test apk
#
-keepattributes SourceFile,LineNumberTable,*Annotation*,InnerClasses,Exceptions,Signature,EnclosingMethod
-renamesourcefileattribute SourceFile
-dontobfuscate
-dontoptimize
-dontshrink

-dontnote org.junit.internal.builders.**
-dontnote org.junit.internal.runners.**
-dontnote org.bouncycastle.**
-dontnote junit.runner.**
-dontnote junit.framework.**
-dontnote com.google.common.**
-dontnote android.support.test.**

-dontwarn com.squareup.javawriter.JavaWriter
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn org.bouncycastle.**
-dontwarn com.google.common.**
-dontwarn com.google.errorprone.**
-dontwarn android.support.test.espresso.**
-dontwarn android.support.test.internal.**
-dontwarn android.test.**
