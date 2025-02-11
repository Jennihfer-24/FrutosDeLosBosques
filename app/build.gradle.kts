plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
    alias(libs.plugins.gms.google.services)
}

android {
    namespace = "cl.virginio.gomez.frutos.secos.frutossecosapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "cl.virginio.gomez.frutos.secos.frutossecosapp"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.play.services.maps)
    implementation(libs.firebase.bom)
    implementation(libs.firebase.analytics)
    implementation (libs.firebase.ui.firestore)
    implementation(libs.google.services)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)
    //noinspection GradleDependency
    implementation(libs.firebase.storage)


}
