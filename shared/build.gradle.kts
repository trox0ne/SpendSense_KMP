plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.android.library)
    alias(libs.plugins.moko.res)
}

kotlin {
    jvm()
    androidTarget()

    sourceSets{
        commonMain {
            dependencies {
                //Compose
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)

                //Resources
                api(libs.resources.core)
                api(libs.resources.compose)

                //Settings
                implementation(libs.settings)

                //Datetime
                implementation(libs.datetime)

                //Di
                api(libs.koin.core)
            }
        }
    }

    jvmToolchain(17)
}

multiplatformResources {
    resourcesPackage.set("ru.multiplatform.spend_sense")
}

android {
    namespace = findProperty("app.namespace").toString()
    compileSdk = findProperty("android.compileSdk").toString().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}



