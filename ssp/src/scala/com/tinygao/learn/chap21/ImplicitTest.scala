package com.tinygao.learn.chap21

/**
  * Created by tinygao on 2017/9/19 0019.
  */
object ImplicitTest {
  implicit  def int2Fraction(n:Int) = Fraction(n,1)
  def main(args: Array[String]): Unit = {
    val result = 3 * Fraction(4,5)
  }

}


