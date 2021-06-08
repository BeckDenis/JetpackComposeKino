import ImplementsDependency.androidTestImplementation
import ImplementsDependency.apiList
import ImplementsDependency.debuggerDependency
import ImplementsDependency.kaptDependency
import ImplementsDependency.listImplements
import ImplementsDependency.testImplementations

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdkVersion(AppVersion.compileSdkVersion)
    buildToolsVersion = AppVersion.buildToolsVersion

    defaultConfig {
        applicationId = AppVersion.applicationId
        minSdkVersion(AppVersion.minSdkVersion)
        targetSdkVersion(AppVersion.targetSdkVersion)
        versionCode = AppVersion.versionCode
        versionName = AppVersion.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppVersion.compose
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    apiList.forEach {
        api(it)
    }
    listImplements.forEach {
        implementation(it)
    }
    debuggerDependency.forEach {
        debugImplementation(it)
    }
    kaptDependency.forEach {
        kapt(it)
    }
    testImplementations.forEach {
        testImplementation(it)
    }
    androidTestImplementation.forEach {
        androidTestImplementation(it)
    }
}