package pl.senordeveloper.template.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Loggable {
    var LOGGER: Logger
    val identityCode: String
    get() = "0x${System.identityHashCode(this).toString(16)}"

    fun trace(format: String, vararg args: Any) = LOGGER.trace(format, args)
    fun trace(format: String, throwable: Throwable) = LOGGER.trace(format, throwable)
    fun debug(format: String, vararg args: Any) = LOGGER.debug(format, args)
    fun debug(format: String, throwable: Throwable) = LOGGER.debug(format, throwable)
    fun info(format: String, vararg args: Any) = LOGGER.info(format, args)
    fun info(format: String, throwable: Throwable) = LOGGER.info(format, throwable)
    fun warn(format: String, vararg args: Any) = LOGGER.warn(format, args)
    fun warn(format: String, throwable: Throwable) = LOGGER.warn(format, throwable)
    fun error(format: String, vararg args: Any) = LOGGER.error(format, args)
    fun error(format: String, throwable: Throwable) = LOGGER.error(format, throwable)


    companion object {
        inline fun <reified T> delegate(): Loggable = object: Loggable {
            override var LOGGER: Logger = LoggerFactory.getLogger(T::class.java)

            override fun debug(format: String, vararg args: Any) {
                super.debug(format, *args)
            }
        }
    }
}