package com.tinygao.learn.chap21

/**
  * Created by tinygao on 2017/9/19 0019.
  */
 case class Fraction(n: Int, i: Int) {
  private val num = 1
  private val den = 2

  def *(other:Fraction) = new Fraction(num * other.num, den * other.den)
}
