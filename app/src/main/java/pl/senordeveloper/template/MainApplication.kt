package pl.senordeveloper.template

import android.app.Application
import pl.senordeveloper.template.logging.Loggable

class MainApplication: Application(), Loggable by Loggable.delegate<MainActivity>() {

    override fun onCreate() {
        super.onCreate()
        debug("onCreate")
    }
}