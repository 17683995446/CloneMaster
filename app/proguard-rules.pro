# Add project specific ProGuard rules here.
# Keep interfaces
-keep interface com.clone.master.** { *; }

# Keep enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep data classes
-keep class com.clone.master.dtos.** { *; }
-keep class com.clone.master.params.** { *; }

# Keep implementation classes
-keep class com.clone.master.impl.** { *; }
