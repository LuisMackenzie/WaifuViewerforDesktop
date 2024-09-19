package com.mackenzie.waifudesktop

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class MainState {
    var showContent: MutableState<Boolean> = mutableStateOf(false)
    var showText: MutableState<Boolean> = mutableStateOf(false)
    var text: MutableState<String> = mutableStateOf("")
    var textField: MutableState<String> = mutableStateOf("")
    val buttonEnabled: Boolean get() = textField.value.isNotEmpty()
    fun isButtonEnabled() = textField.value.isNotEmpty()
}
