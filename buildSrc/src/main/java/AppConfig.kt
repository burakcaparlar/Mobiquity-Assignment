@file:Suppress("PackageDirectoryMismatch")

object ConfigData {
    const val compileSdkVersion = 32
    const val applicationId = "com.example.mobiquityassignment"
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    val versionCode = calculateVersionCode()
    val versionName = calculateVersionName()
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    private const val versionMajor = 2
    private const val versionMinor = 0
    private const val versionPatch = 1

    private fun calculateVersionCode(): Int = versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100
    private fun calculateVersionName(): String = "${versionMajor}.${versionMinor}.${versionPatch}"
}