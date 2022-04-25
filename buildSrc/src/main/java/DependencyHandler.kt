import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAppDependencies() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.LIFECYCLE_LIVEDATA_KTX)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)
    implementation(Dependencies.MOSHI_KOTLIN)
    implementation(Dependencies.RETROFIT_CONVERTER_MOSHI)
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.OK_HTTP3)
    implementation(Dependencies.OK_HTTP3_LOGGING_INTERCEPTOR)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.SWIPE_REFRESH_LAYOUT)
    implementation(Dependencies.LOTTIE)

    kapt(Dependencies.GLIDE_COMPILER)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    kapt(Dependencies.ROOM_COMPILER)
    kapt(Dependencies.MOSHI_CODEGEN)

    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.JUNIT_KTX)
    testImplementation(Dependencies.TRUTH)
    testImplementation(Dependencies.MOCKK)
    testImplementation(Dependencies.ROBOLECTRIC)
    testImplementation(Dependencies.CORE_TESTING)
    testImplementation(Dependencies.COROUTINES_TEST)
    testImplementation(Dependencies.MOCK_WEB_SERVER)

    androidTestImplementation(Dependencies.JUNIT_EXTENSION)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
}

fun DependencyHandler.`implementation`(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.`kapt`(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.`testImplementation`(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.`androidTestImplementation`(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)