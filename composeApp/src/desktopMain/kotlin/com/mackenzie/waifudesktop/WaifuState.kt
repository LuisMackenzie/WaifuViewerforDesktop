package com.mackenzie.waifudesktop

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

class WaifuState {
    var state = mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state.update { it.copy(loading = true) }
            getNotes { notes -> state.update { UiState(notes = notes) } }
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}

class MainState {
    var showContent: MutableState<Boolean> = mutableStateOf(false)
    var showText: MutableState<Boolean> = mutableStateOf(false)
    var text: MutableState<String> = mutableStateOf("")
    var textField: MutableState<String> = mutableStateOf("")
    val buttonEnabled: Boolean get() = textField.value.isNotEmpty()
    fun isButtonEnabled() = textField.value.isNotEmpty()
}
