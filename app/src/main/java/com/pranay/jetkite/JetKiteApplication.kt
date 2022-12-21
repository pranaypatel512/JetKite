package com.pranay.jetkite

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetKiteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
