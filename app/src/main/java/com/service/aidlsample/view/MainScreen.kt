package com.service.aidlsample.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.service.aidlsample.MainActivity


@Composable
fun MainScreen() {
    var result by remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val mainActivity = context as MainActivity

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text(text = "Result: $result")
        Button(onClick = {
            if (mainActivity.isBound) {
                result = ((mainActivity.aidlService?.add(3, 5) ?: 0) as? Int)?:0
            }
        }) {
            Text(text = "Add 3 + 5")
        }
    }
}