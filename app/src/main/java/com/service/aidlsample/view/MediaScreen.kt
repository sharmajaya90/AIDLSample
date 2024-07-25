// MediaScreen.kt
package com.service.aidlsample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.service.aidlsample.MainActivity

@Composable
fun MediaScreen() {
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val clientActivity = context as MainActivity

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text(text = "Music Playback")
        Spacer(modifier = Modifier.padding(0.dp,50.dp,0.dp,0.dp))
        Row {
            Button(onClick = {
                if (clientActivity.isBound) {
                    clientActivity.mediaService?.play()
                }
            }) {
                Text(text = "Play")
            }
            Button(onClick = {
                if (clientActivity.isBound) {
                    clientActivity.mediaService?.pause()
                }
            }) {
                Text(text = "Pause")
            }
            Button(onClick = {
                if (clientActivity.isBound) {
                    clientActivity.mediaService?.stop()
                }
            }) {
                Text(text = "Stop")
            }
        }
        Button(onClick = {
            if (clientActivity.isBound) {
                isPlaying = clientActivity.mediaService?.isPlaying() ?: false
            }
        }) {
            Text(text = if (isPlaying) "Playing" else "Not Playing")
        }
    }
}
