package com.example.a1

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


class ZadaniaTlo  {

    fun s1() = runBlocking {
        launch (Dispatchers.Default) {
            delay(2000L)
            println("a1: Zosia")
        }
        val job1 = launch {
            delay(1000L)
            println("a1: Hi hi")
        }
        job1.join()
        println("a1: Nazywam się ")

    }

    private suspend fun s10( a: Int): Int  {
        var z = a
        for (i in 0..10) {
            z = i * a
            delay( 10L) //instead doing something useful
        }
        return z
    }

    fun a2() = runBlocking {
        val time = measureTimeMillis {
            val a1 = async(start = CoroutineStart.LAZY) { s10(20) }
            val a3 = async { s10(10) }
            val a2 = async(start = CoroutineStart.LAZY) { s10(10) }
            val a4 = async { s10(5) }
            a1.start()
            a2.start()
            val z3 = a3.await()
            val z4 = a4.await()
            println("a2: Odpowiedź jest ${a1.await() + a2.await()}")
            println("a2: Odpowiedź jest ${z3 + z4}")
        }
        println("a2: czas obliczeń = $time ms")
    }


}