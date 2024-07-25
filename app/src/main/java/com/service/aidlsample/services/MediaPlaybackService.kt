package com.service.aidlsample.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.service.aidlsample.IMediaPlaybackService


class MediaPlaybackService : Service() {
    private val binder = object : IMediaPlaybackService.Stub() {
        override fun play() {
            // Implement play functionality

        }

        override fun pause() {
            // Implement pause functionality
        }

        override fun stop() {
            // Implement stop functionality
        }

        override fun isPlaying(): Boolean {
            // Implement isPlaying functionality
            return false
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
}