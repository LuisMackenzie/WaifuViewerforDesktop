package com.mackenzie.waifudesktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Waifu Viewer For Desktop",
    ) {
        App()
    }
}