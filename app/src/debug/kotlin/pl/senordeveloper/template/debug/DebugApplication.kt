package pl.senordeveloper.template.debug

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import pl.senordeveloper.template.BuildConfig
import pl.senordeveloper.template.logging.Loggable

class DebugApplication : Application(), Loggable by Loggable.delegate<DebugApplication>() {
    override fun onCreate() {
        super.onCreate()
        debug("onCreate()")

        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.start()
        }
    }
}