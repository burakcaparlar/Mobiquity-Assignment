// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.github.ben-manes.versions") version Version.GRADLE_VERSIONS_PLUGIN_VERSION
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(ClassPath.GRADLE)
        classpath(kotlin("gradle-plugin", version = Version.KOTLIN_VERSION))
        classpath(ClassPath.DAGGER_HILT_GRADLE_PLUGIN)
        classpath(ClassPath.SAFE_ARGS_GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}