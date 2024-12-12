package ru.multiplatform.spend_sense.platform

actual class DeviceInfo actual constructor() {
    actual val osName: String = System.getProperty("os.name") ?: "Desktop"
    actual val osVersion: String = System.getProperty("os.version") ?: "Unknown version"
    actual val model: String = "Desktop"
    actual val cpu: String = System.getProperty("os.arch") ?: "Unknown cpu"
    actual val screenWidth: Int = 0
    actual val screenHeight: Int = 0
    actual val screenDestiny: Int = 0

    actual fun getSummary(): String =
        "osName $osName\n" +
                "osVersion $osVersion\n" +
                "model $model\n" +
                "cpu $cpu"
}