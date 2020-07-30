package com.rompos.idscan.app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microblink.entities.recognizers.Recognizer
import com.microblink.entities.recognizers.RecognizerBundle
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer
import com.microblink.uisettings.ActivityRunner
import com.microblink.uisettings.BlinkIdUISettings

class ScanActivity : AppCompatActivity() {

    private lateinit var recognizer: BlinkIdCombinedRecognizer
    private lateinit var recognizerBundle: RecognizerBundle
    private var MY_REQUEST_CODE = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        recognizer = BlinkIdCombinedRecognizer()
        recognizerBundle = RecognizerBundle(recognizer)
    }

        fun startScanning() {
            val settings = BlinkIdUISettings(recognizerBundle)
            ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, settings)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                recognizerBundle.loadFromIntent(data)

                val result = recognizer.result
                if (result.resultState == Recognizer.Result.State.Valid) {
                    // result is valid, you can use it however you wish
                }
            }
        }
    }
}
