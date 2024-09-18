package com.mackenzie.waifudesktop

class Greeting {
    private val platform = getPlatform()
    private val user = getUser()

    fun greet(): String {
        return "Hola, $user, Estas usando ${platform.name}!"
    }
}