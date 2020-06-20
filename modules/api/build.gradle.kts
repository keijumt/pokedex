plugins {
    `android-partial`
    kotlin("plugin.serialization")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(Dep.OkHttp.client)

    implementation(Dep.Retrofit.client)
    implementation(Dep.Retrofit.kotlinSerializationConverter)

    implementation(Dep.DaggerHilt.core)
    kapt(Dep.DaggerHilt.compiler)
    implementation(Dep.DaggerHilt.common)
    implementation(Dep.DaggerHilt.viewmodel)
}