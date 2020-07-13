package org.jitsi.metaconfig

import kotlin.reflect.KType
import kotlin.reflect.typeOf

/**
 * A [ConfigSource] is what is used to retrieve configuration values
 * from some location.
 */
interface ConfigSource {
    /**
     * Given a [type], return a function which takes in a
     * configuration property key (aka a key 'name') and returns the value
     * of the property at the given name as the type referred to by [type].
     *
     * The return getter should return the value corresponding to the given
     * key, or throw [ConfigException.UnsupportedType] if the type isn't
     * supported.
     */
    fun getterFor(type: KType): (String) -> Any

    /**
     * A name for this [ConfigSource] to give extra context in the
     * event of errors
     */
    val name: String
}