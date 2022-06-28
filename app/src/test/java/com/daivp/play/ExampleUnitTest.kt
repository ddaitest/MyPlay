package com.daivp.play

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Tests.test1()
        assertEquals(4, 2 + 2)
//        Thread.sleep(2000L)
    }

    @Test
    fun test2() {
        Tests.test2()
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test3() {
        Tests.test3()
        Thread.sleep(5000L)
        assertEquals(4, 2 + 2)
    }
}