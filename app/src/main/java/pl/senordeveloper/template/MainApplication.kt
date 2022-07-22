package pl.senordeveloper.template

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import pl.senordeveloper.template.logging.Loggable

class MainApplication: Application(), Loggable by Loggable.delegate<MainActivity>() {

    override fun onCreate() {
        super.onCreate()
        debug("onCreate")
    }
}