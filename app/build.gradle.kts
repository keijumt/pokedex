import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Version.compileSdkVersion)

    defaultConfig {
        applicationId = "com.keijumt.pokedex"
        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures.dataBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures.dataBinding = true

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["dagger.hilt.disableModulesHaveInstallInCheck"] = "true"
            }
        }
    }
}

tasks {
    withType<KotlinCompile> {
        all {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
            }
        }
    }
}

dependencies {
    implementation(project(Module.pokedex))
    implementation(project(Module.api))
    implementation(project(Module.resource))
    implementation(project(Module.common))

    implementation(Dep.Kotlin.stdlib)

    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.recyclerview)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.fragmentKtx)
    implementation(Dep.AndroidX.livedataKtx)
    implementation(Dep.AndroidX.viewmodelKtx)

    implementation(Dep.Navigation.runtimeKtx)
    implementation(Dep.Navigation.fragmentKtx)
    implementation(Dep.Navigation.uiKtx)

    implementation(Dep.DaggerHilt.core)
    kapt(Dep.DaggerHilt.compiler)
    kapt(Dep.DaggerHilt.androidxCompiler)
    implementation(Dep.DaggerHilt.common)
    implementation(Dep.DaggerHilt.viewmodel)

    compileOnly(Dep.Dagger.assistedInjectAnnotations)
    kapt(Dep.Dagger.assistedInjectProcessor)

    implementation(Dep.material)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.espresso)
}