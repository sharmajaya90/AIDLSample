package com.service.aidlsample.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.service.aidlsample.IMyAidlInterface


class VerifyAidlService : Service() {
    private val binder = object : IMyAidlInterface.Stub(){
        override fun add(a: Int, b: Int): Int {
            return a + b
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
}