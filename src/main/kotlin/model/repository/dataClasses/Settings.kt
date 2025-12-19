package model.repository.dataClasses

import kotlinx.serialization.Serializable

@Serializable
data class Settings(
    val maxDumps: Int,
    val autoResizeScreenshot: Boolean,
    val tryRoot: Boolean,
    val preDumpShellCommands: List<String>
) {
    companion object {
        val DefaultEmpty = Settings(
            // History limit
            maxDumps = 15,
            // Whether the window resize just centers the screenshot or
            // centers and fits to the screen
            autoResizeScreenshot = false,
            // Whether to try to restart the device as root on dump
            tryRoot = true,
            // A list of ADB commands to execute before dumping.
            // We've had an issue with an app using UI Automator causing the dump to fail
            // i.e. adding `am force-stop PACKAGENAME` before the dump saves a lot of pain
            // Related to the note in the README on Appium server.
            preDumpShellCommands = emptyList()
        )
    }
}
