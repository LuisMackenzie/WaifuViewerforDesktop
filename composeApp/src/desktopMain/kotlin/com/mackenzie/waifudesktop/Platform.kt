package com.mackenzie.waifudesktop

class JVMPlatform {
    val name: String = "Java ${System.getProperty("java.version")}"
}

fun getPlatform() = JVMPlatform()

fun getUser() = System.getProperty("user.name")