plugins {
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.adnroid) apply false
}

val firstTask = "MyCustomTask1"
val secondTask = "MyCustomTask2"

val key = "someKey"

val myGroup = "custom group"

tasks.register(firstTask)

tasks.configureEach {
    if (name.contains("Custom")) {
        group = myGroup
    }
}

tasks.register(secondTask)

