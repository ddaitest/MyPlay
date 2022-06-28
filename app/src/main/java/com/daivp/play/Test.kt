package com.daivp.play

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.merge

object Tests {

    fun test1() {
        val t1 = System.currentTimeMillis()

        //        val mydispatcher = newSingleThreadContext("DDAI")
        fun main() = runBlocking {
            println("test1. 1 @${System.currentTimeMillis() - t1}")

//            val r1 = async { work(1) }
//            val r2 = async { work(2) }
//            val r3 = async { work(3) }
            repeat(4) {
                launch { work(it) }
            }

            println("test1. 2 @${System.currentTimeMillis() - t1}")
//            val all = r1.await()+r2.await()+r3.await()
//            println("test1. 3 @${System.currentTimeMillis() - t1}  == $all")
            println("test1. 4 @${System.currentTimeMillis() - t1}")
        }
        main()
    }

    suspend fun work(x: Int): Int {
        println("[$x] Thread = ${Thread.currentThread().name}")
        delay(1000L)
        println("[$x] WORK END")
        return x
    }

    fun test2() {
        runBlocking {
            println("test2 start")
            work(1)
            work(2)
            work(3)
            work(4)
            println("test2 end")
        }
    }

    fun test3() {
        GlobalScope.launch {
            val add3 = 5
        }
    }

    fun test4(){
        val add = 5
    }
}