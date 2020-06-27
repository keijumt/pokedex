plugins {
    `android-partial`
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildFeatures.dataBinding = true

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["dagger.hilt.disableModulesHaveInstallInCheck"] = "true"
            }
        }
    }
}

dependencies {
    implementation(project(Module.api))
    implementation(project(Module.resource))
    implementation(project(Module.common))

    implementation(Dep.Kotlin.stdlib)

    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.fragmentKtx)
    implementation(Dep.AndroidX.livedataKtx)
    implementation(Dep.AndroidX.viewmodelKtx)

    implementation(Dep.Navigation.fragmentKtx)
    implementation(Dep.Navigation.uiKtx)

    implementation(Dep.paging)

    implementation(Dep.DaggerHilt.core)
    kapt(Dep.DaggerHilt.compiler)
    kapt(Dep.DaggerHilt.androidxCompiler)
    implementation(Dep.DaggerHilt.common)
    implementation(Dep.DaggerHilt.viewmodel)

    compileOnly(Dep.Dagger.assistedInjectAnnotations)
    kapt(Dep.Dagger.assistedInjectProcessor)

    implementation(Dep.Glide.core)
    kapt(Dep.Glide.compiler)

    implementation(Dep.material)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.Test.espresso)
}