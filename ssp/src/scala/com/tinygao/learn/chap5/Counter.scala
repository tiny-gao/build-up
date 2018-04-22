package com.tinygao.learn.chap5

/**
  * Created by tinygao on 2017/9/20 0020.
  */
class Counter {
  private var value = 9
  def increment(): Unit = {
    if(value==Int.MaxValue) value = 0
    value+=1
  }
  def  current() = value
}
