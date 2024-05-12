package com.blackhand.moviekmp.common.utils

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

// provide initialize for io in Dispatcher from each platform
internal expect fun provideDispatcher(): Dispatcher