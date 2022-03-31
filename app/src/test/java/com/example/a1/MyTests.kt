package com.example.a1

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MyTests {

    @Test
    fun test1 ()  {
        val task1  = ZadaniaTlo()
        task1.s1()
    }

    @Test
    fun test2() {
        val task2 = ZadaniaTlo()
        task2.a2()
    }
}