package com.tinygao.learn.chap2

import scala.collection.immutable.StringOps

/**
  * Created by tinygao on 2017/9/18 0018.
  */
object ExcOther {
  def countdown(n:Int): Unit = {
    for(i <- n to 0 by -1) {
      println(i)
    }
  }
  def exec6(input:String): Unit = {
    var result:Long = 1
    for(i <- input) {
        result=result*i
    }
    println(result)
  }

  def exec7(input:String):Unit = {
    var result =1L
    new StringOps(input).foreach((x)=>{
      result = result*x
    })
    println(result)
  }

  def product(s:String):Long = {
    if(s.length == 1)  s.charAt(0) else s.charAt(0) * product(s.substring(1))
  }

  def exec10(x:Int, n:Int):Double = {
    if(n==0) 1
    else if (n<0) 1/exec10(x, -n)
    else if(n%2==0) exec10(x, n/2) * exec10(x, n/2) else  x * exec10(x, n-1)
  }

  def main(args: Array[String]): Unit = {
    countdown(11)
    exec6("Hello")
    exec7("Hello")
    println(product("Hello"))
    println(exec10(2, -2))
  }
}
