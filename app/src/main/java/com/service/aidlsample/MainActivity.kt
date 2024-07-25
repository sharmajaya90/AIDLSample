package com.service.aidlsample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.service.aidlsample.services.MediaPlaybackService
import com.service.aidlsample.services.VerifyAidlService
import com.service.aidlsample.ui.theme.AIDLSampleTheme
import com.service.aidlsample.view.MainScreen
import com.service.aidlsample.view.MediaScreen

class MainActivity : ComponentActivity() {
    var mediaService: IMediaPlaybackService? = null
    var aidlService: IMyAidlInterface? = null
    var isBound = false


    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
           // aidlService = IMyAidlInterface.Stub.asInterface(service)
            mediaService = IMediaPlaybackService.Stub.asInterface(service)


            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
           // aidlService = null
            mediaService = null
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           // MainScreen()
            MediaScreen()
        }
        bindService()
    }

    private fun bindService() {
        /*Intent(this, VerifyAidlService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }*/
        Intent(this, MediaPlaybackService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }
}

