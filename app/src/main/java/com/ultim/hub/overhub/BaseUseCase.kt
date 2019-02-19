package com.ultim.hub.overhub

import kotlin.coroutines.experimental.suspendCoroutine

class BaseUseCase {

    suspend fun downloadDataAsync(): Any {
        val a = test()
        return suspendCoroutine { cont ->
            cont.resume("12")
            //cont.resumeWithException(Throwable())
        }
    }

    fun test(): Int{
        val a = 5;
        return a
    }

}