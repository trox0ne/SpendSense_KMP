plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.adnroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = findProperty("app.namespace").toString()
    compileSdk = findProperty("android.compileSdk").toString().toInt()
    defaultConfig {
        minSdk = findProperty("android.minSdk").toString().toInt()
        targetSdk = findProperty("android.targetSdk").toString().toInt()
        applicationId = findProperty("app.namespace").toString()
        versionCode = 1
        versionName = "0.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(project(":shared"))
}
