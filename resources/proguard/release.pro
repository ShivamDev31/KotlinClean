# Set of ProGuard rules applied to release builds
#
-keepattributes SourceFile,LineNumberTable,*Annotation*,InnerClasses,Exceptions,Signature,EnclosingMethod
-renamesourcefileattribute SourceFile
-dontobfuscate
-dontoptimize
-dontnote **

# We own this code, and everything in this package is definitely defining our domain. Better not to have ProGuard messing with it
-keep public class com.newsuk.thesun.mobile.** { *; }
-keep public class com.newsuk.imageloader.** { *; }

# Retrofit
-dontwarn retrofit2.**
-dontwarn okio.**
-dontwarn javax.annotation.**

# Dagger
-dontwarn  dagger.android.DispatchingAndroidInjector

# Ooyala (VideoPlayer)
-dontwarn com.ooyala.**

# Brightcove (VideoPlayer)
-dontwarn com.brightcove.player.display.VideoDisplayComponent
-dontwarn com.brightcove.player.view.BrightcoveClosedCaptioningSurfaceView
-dontwarn com.brightcove.player.view.BrightcoveClosedCaptioningSurfaceView$1
-dontwarn com.google.**
-dontwarn tv.freewheel.**
-dontwarn com.adobe.**
-keep public class com.brightcove.player.** { public *; }
-keepclassmembers public class com.brightcove.player.** { public *; }
-keepclasseswithmembers public class com.brightcove.player.** { public *; }

# UrbanAirship
-dontwarn com.urbanairship.push.iam.view.BannerCardView

# NewRelic (Analytics)
-keep class com.newrelic.** { *; }
-dontwarn com.newrelic.**

# ComScore (Analytics)
-keep class com.comscore.** { *; }
-dontwarn com.comscore.**

# Glide
-dontwarn android.graphics.Bitmap$Config
-dontwarn android.app.FragmentManager

# Prebid (Advert)
-keep class org.prebid**
-keep class org.prebid** { *; }

# For Google Play Services Ads PublisherAdRequest
-keep class com.google.android.gms.ads.doubleclick.PublisherAdRequest {
   public *;
}

# moat (Analytics for Ads)
-keep class com.moat.** { *; }
-dontwarn com.moat.**

# tune (Analytics)
-keep public class com.tune.** { public *; }
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
