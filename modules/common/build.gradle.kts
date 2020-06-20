plugins {
    `android-partial`
}

android.buildFeatures.dataBinding = true

dependencies {
    implementation(Dep.Glide.core)
    kapt(Dep.Glide.compiler)
}