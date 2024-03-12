package com.nareshittechnologies.fragmentcommunication

class MyClass {
    companion object{
        // What ever you write here can be accessed without needing to create an object
        var i = 0;
        fun initialize():MyClass{
            i++
            return MyClass()
        }
    }

    fun mySum(a:Int, b:Int):Int{
        return a+b;
    }
}

fun main(){
    val obj1 = MyClass.initialize()
    val obj2 = MyClass.initialize()
    val obj3 = MyClass.initialize()
    val obj4 = MyClass.initialize()
    val obj5 = MyClass.initialize()
    println(obj1.mySum(12,13))
}