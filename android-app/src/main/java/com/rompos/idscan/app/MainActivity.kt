package com.rompos.idscan.app

import dev.icerock.moko.widgets.screen.BaseApplication
import dev.icerock.moko.widgets.screen.HostActivity

class MainActivity : HostActivity() {
    override val application: BaseApplication
        get() {
            return MainApplication.mppApplication
        }
}
