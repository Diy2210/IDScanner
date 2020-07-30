package com.rompos.idscan.app

import android.app.Application
import com.rompos.idscan.mpp.App

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        mppApplication = App().apply { initialize() }
    }

    companion object {
        lateinit var mppApplication: App
    }
}
