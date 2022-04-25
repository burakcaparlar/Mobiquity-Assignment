@file:Suppress("PackageDirectoryMismatch")

object ClassPath {
    const val GRADLE = "com.android.tools.build:gradle:${Version.GRADLE_VERSION}"
    const val DAGGER_HILT_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.DAGGER_HILT_VERSION}"
    const val SAFE_ARGS_GRADLE_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION_VERSION}"
}