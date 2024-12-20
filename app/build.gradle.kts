plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id ("io.gitlab.arturbosch.detekt")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.jesse.c24"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jesse.c24"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    val navVersion = "2.7.1"
    val hiltVersion = "2.48.1"
    val roomVersion = "2.6.1"

    //NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //DaggerHilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.1")

    //Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")

    //Room
    //implementation ("androidx.room:room-ktx:2.5.0") // 2.4.2
    implementation ("androidx.room:room-runtime:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")

    //DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    // Location Services
    implementation ("com.google.android.gms:play-services-location:21.1.0")
    //livedata and coroutines
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    //ZXing
    implementation("com.journeyapps:zxing-android-embedded:4.2.0")

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}