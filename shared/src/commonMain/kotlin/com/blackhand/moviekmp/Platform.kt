package com.blackhand.moviekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform