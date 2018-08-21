# Set of ProGuard rules applied to espresso builds
#
-include release.pro

-keep public class okhttp3.internal.Util { *;}
-keep public class okhttp3.internal.Internal { *; }
-keep public class okhttp3.internal.ws.** { *; }
-keep public class okhttp3.mockwebserver.MockWebServer { *; }
-keep public class android.support.v7.widget.RecyclerView { void scrollToPosition(int); }
