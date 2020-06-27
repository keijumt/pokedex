plugins {
    `android-partial`
    id("androidx.navigation.safeargs.kotlin")
}

android.buildFeatures.dataBinding = true

dependencies {
    implementation(Dep.Glide.core)
    kapt(Dep.Glide.compiler)

    implementation(Dep.Navigation.runtimeKtx)
    implementation(Dep.Navigation.fragmentKtx)
    implementation(Dep.Navigation.uiKtx)
}