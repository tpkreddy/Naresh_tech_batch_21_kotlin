package com.nareshittechnologies.co_routines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    runBlocking {
        println("Main Starts: ${Thread.currentThread().name}")
        /*GlobalScope.launch {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
        }*/

        val jobdeferred: Deferred<String> = async {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
            "I\'m done"
        }

        //to Schedule a Job, call
        println(jobdeferred.await())
        delayForSomeTime(2000)
        println("Main Completes: ${Thread.currentThread().name}")
    }
}

suspend fun delayForSomeTime(i: Long) {
    delay(i)
}
