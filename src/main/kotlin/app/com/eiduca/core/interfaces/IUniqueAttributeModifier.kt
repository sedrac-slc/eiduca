package app.com.eiduca.core.interfaces

import com.aventrix.jnanoid.jnanoid.NanoIdUtils

interface IUniqueAttributeModifier {
    fun updateUniqueAttributes()

    fun nanoId(): String = "#${NanoIdUtils.randomNanoId()}"
}