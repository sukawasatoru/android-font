class Depend {
    static final arch = new Arch()
    static final errorprone = "com.google.errorprone:error_prone_core:$Version.errorprone"
    static final dagger = new Dagger()
    static final glide = new Glide()
    static final gradle = new Gradle()
    static final kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$Version.kotlin"
    static final leakcanary = new Leakcanary()
    static final orma = new Orma()
    static final rx = new Rx()
    static final support = new Support()

    static class Arch {
        final lifecycle = "android.arch.lifecycle:extensions:$Version.arch.live"
        final lifecycleCompiler = "android.arch.lifecycle:compiler:$Version.arch.live"
    }

    static class Dagger {
        final dagger = "com.google.dagger:dagger:$Version.dagger"
        final compiler = "com.google.dagger:dagger-compiler:$Version.dagger"
    }

    static class Glide {
        final glide = "com.github.bumptech.glide:glide:$Version.glide"
        final okhttp3 = "com.github.bumptech.glide:okhttp3-integration:$Version.glide"
    }

    static class Gradle {
        final android = "com.android.tools.build:gradle:$Version.gradle.android"
        final androidCacheFix =
                "gradle.plugin.org.gradle.android:android-cache-fix-gradle-plugin:$Version.gradle.androidCacheFix"
        final kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$Version.kotlin"
        final errorprone = "net.ltgt.gradle:gradle-errorprone-plugin:$Version.gradle.errorprone"
    }

    static class Leakcanary {
        final debug = "com.squareup.leakcanary:leakcanary-android:$Version.leakcanary"
        final release = "com.squareup.leakcanary:leakcanary-android-no-op:$Version.leakcanary"
        final test = "com.squareup.leakcanary:leakcanary-android-no-op:$Version.leakcanary"
    }

    static class Orma {
        final orma = "com.github.gfx.android.orma:orma:$Version.orma"
        final compiler = "com.github.gfx.android.orma:orma-processor:$Version.orma"
    }

    static class Rx {
        final java = "io.reactivex.rxjava2:rxjava:$Version.rx.java"
        final android = "io.reactivex.rxjava2:rxandroid:$Version.rx.android"
    }

    static class Support {
        final constraint = "com.android.support.constraint:constraint-layout:$Version.support.constraint"
        final annotations = "com.android.support:support-annotations:$Version.support.support"
        final recyclerview = "com.android.support:recyclerview-v7:$Version.support.support"
        final cardview = "com.android.support:cardview-v7:$Version.support.support"
        final leanback = "com.android.support:leanback-v17:$Version.support.support"
        final tvProvider = "com.android.support:support-tv-provider:$Version.support.support"
        final compat = "com.android.support:support-compat:$Version.support.support"
        final compatV4 = "com.android.support:support-v4:$Version.support.support"
        final compatV7 = "com.android.support:appcompat-v7:$Version.support.support"
        final coreUtils = "com.android.support:support-core-utils:$Version.support.support"
    }
}
