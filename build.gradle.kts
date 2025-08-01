import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
}

extra["compileSdkVersion"] = 36
extra["minSdkVersion"] = 26
extra["targetSdkVersion"] = 36
extra["javaVersionCompatibility"] = JavaVersion.VERSION_11
extra["jvmTarget"] = JvmTarget.JVM_11