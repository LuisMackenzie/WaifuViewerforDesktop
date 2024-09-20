package com.mackenzie.waifudesktop

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TextSnippet
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun WaifuApp(waifu : WaifuState) {
    val notes = waifu.state.value.notes
    if (notes == null) {
        LaunchedEffect(true) {
            waifu.loadNotes()
        }
    }
    MaterialTheme {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (waifu.state.value.loading) CircularProgressIndicator()
            notes?.let {
                NotesList(it)
            }
        }
    }
}

@Composable
private fun NotesList(notes: List<Note>) {
    LazyColumn(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(text = note.title, style = MaterialTheme.typography.h4, modifier = Modifier.weight(1f))
                        when (note.type) {
                            Note.Type.AUDIO -> Icon(imageVector = Icons.Default.Mic, contentDescription = "Audio")
                            Note.Type.TEXT -> Icon(imageVector = Icons.AutoMirrored.Filled.TextSnippet, contentDescription = "Text")
                            Note.Type.NORMAL -> Icon(imageVector = Icons.Default.Image, contentDescription = "Image")
                        }
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(note.desc, style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(note.content)
                }
            }
        }
    }
}