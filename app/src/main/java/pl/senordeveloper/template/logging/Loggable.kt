package pl.senordeveloper.template.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Loggable {
    var LOGGER: Logger

    fun trace(format: String, vararg args: Any) = LOGGER.trace(format, args)
    fun debug(format: String, vararg args: Any) = LOGGER.debug(format, args)
    fun info(format: String, vararg args: Any) = LOGGER.info(format, args)
    fun warn(format: String, vararg args: Any) = LOGGER.warn(format, args)
    fun error(format: String, vararg args: Any) = LOGGER.error(format, args)

    companion object {
        inline fun <reified T> delegate(): Loggable = object: Loggable {
            override var LOGGER: Logger = LoggerFactory.getLogger(T::class.java)
        }
    }
}