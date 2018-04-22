package com.tinygao.learn.chap5

/**
  * Created by tinygao on 2017/9/20 0020.
  */
class Chap5 {

}


class BankAccount{
  val balance:String = ""
  def deposit(){}
  def withdraw(){}
}

class Time(val hours:Int, val minutes:Int){
  def before(other:Time):Boolean={
    if(hours > other.hours ) {
      false
    }
    if(hours < other.hours) {
      true
    }
    if(minutes > other.minutes ) {
      false
    }
    if(minutes < other.minutes) {
      true
    }
    false
  }
}