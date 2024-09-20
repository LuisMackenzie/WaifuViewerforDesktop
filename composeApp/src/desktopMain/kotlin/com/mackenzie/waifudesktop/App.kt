package com.mackenzie.waifudesktop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import waifuviewerfordesktop.composeapp.generated.resources.Res
import waifuviewerfordesktop.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(state : MainState) {
    MaterialTheme {

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            TextField(
                value = state.textField.value,
                onValueChange = { newText ->
                state.textField.value = newText
            })
            Text(text = state.text.value)
            Button(onClick = {
                state.showText.value = !state.showText.value
                state.text.value = state.textField.value.buildMessage()
                if(!state.showText.value) {
                    state.text.value = ""
                    state.textField.value = ""
                }
            }, enabled = state.buttonEnabled) {
                if(state.showText.value) Text("Limpiar") else Text("Saludar")
            }


            Button(onClick = { state.showContent.value = !state.showContent.value }) {
                if(state.showContent.value) Text("Ocultame!") else Text("Muestrame!")
            }
            AnimatedVisibility(state.showContent.value) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

fun String.buildMessage() = "Hola, $this!"
