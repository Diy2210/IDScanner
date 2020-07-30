package com.rompos.idscan.app

import android.app.Application
import com.microblink.MicroblinkSDK
import com.rompos.idscan.mpp.App

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        mppApplication = App().apply { initialize() }

        MicroblinkSDK.setLicenseKey(getString(R.string.app_token), this)
    }

    companion object {
        lateinit var mppApplication: App
    }
}
