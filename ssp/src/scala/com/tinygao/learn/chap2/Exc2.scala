package com.tinygao.learn.chap2

/**
  * Created by tinygao on 2017/9/18 0018.
  */
object Exc2 {
  //一个空的{}块，返回值是()，是Unit类型，对应java中的void
  def nullBlock() {}

  def main(args: Array[String]): Unit = {
    print(nullBlock())
    print(nullBlock().getClass)
  }
}
