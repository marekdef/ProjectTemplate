package pl.senordeveloper.template.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Loggable {
    val logger: Logger
    val identityCode: String
    get() = "0x${System.identityHashCode(this).toString(16)}"

    fun trace(format: String, vararg args: Any) = logger.trace(format, args)
    fun trace(format: String, throwable: Throwable) = logger.trace(format, throwable)
    fun debug(format: String, vararg args: Any) = logger.debug(format, args)
    fun debug(format: String, throwable: Throwable) = logger.debug(format, throwable)
    fun info(format: String, vararg args: Any) = logger.info(format, args)
    fun info(format: String, throwable: Throwable) = logger.info(format, throwable)
    fun warn(format: String, vararg args: Any) = logger.warn(format, args)
    fun warn(format: String, throwable: Throwable) = logger.warn(format, throwable)
    fun error(format: String, vararg args: Any) = logger.error(format, args)
    fun error(format: String, throwable: Throwable) = logger.error(format, throwable)


    companion object {
        inline fun <reified T> delegate(): Loggable = object: Loggable {
            override val logger: Logger = LoggerFactory.getLogger(T::class.java)

            override fun debug(format: String, vararg args: Any) {
                super.debug(format, *args)
            }
        }
    }
}