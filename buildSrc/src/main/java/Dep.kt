@Suppress("unused", "MayBeConstant")
object Dep {
    object GradlePlugin {
        val android = "com.android.tools.build:gradle:4.0.0"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72"
        val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.3.72"
        val hilt = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
        val navigation =
            "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-rc01"
    }

    object Kotlin {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.3.72"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.3.0-alpha01"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta7"
        val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha03"

        val coreKtx = "androidx.core:core-ktx:1.5.0-alpha01"
        val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.0-alpha06"
        val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha04"
        val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha04"
    }

    object DaggerHilt {
        val core = "com.google.dagger:hilt-android:2.28-alpha"
        val compiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
        val androidxCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
        val common = "androidx.hilt:hilt-common:1.0.0-alpha01"
        val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
    }

    object Dagger {
        val assistedInjectAnnotations =
            "com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2"
        val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor-dagger2:0.5.2"
    }

    object Navigation {
        val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:2.3.0-rc01"
        val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.3.0-rc01"
        val uiKtx = "androidx.navigation:navigation-ui-ktx:2.3.0-rc01"
    }

    object Retrofit {
        val client = "com.squareup.retrofit2:retrofit:2.9.0"
        val kotlinSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.5.0"
    }

    object OkHttp {
        val client = "com.squareup.okhttp3:okhttp:4.7.2"
    }

    object Glide {
        val core = "com.github.bumptech.glide:glide:4.11.0"
        val compiler = "com.github.bumptech.glide:compiler:4.11.0"
    }

    val paging = "androidx.paging:paging-runtime:3.0.0-alpha01"
    val material = "com.google.android.material:material:1.3.0-alpha01"

    object Test {
        const val junit = "junit:junit:4.13"
        const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
    }
}