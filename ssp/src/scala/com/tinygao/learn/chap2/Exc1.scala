package com.tinygao.learn.chap2

/**
  * Created by tinygao on 2017/9/17 0017.
  */
object Exc1 {
  def signum(value:Int):Int={
    if(value>0) 1 else (if(value<0) -1 else 0)
  }

  def main(args: Array[String]): Unit = {
    println(signum(3))
    println(signum(0))
    println(signum(-3))
  }
}

