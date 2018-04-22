package com.tinygao.spi.ssp
/**
  * Created by tinygao on 2017/9/17 0017.
  */
object VariableSubstitution {
  val varPat = """\$\{[^\}\$\u0020]+\}"""r

  def getSubstitute(value: String):String = {

    return "test"
  }

  def substitue(expr:String):String = {
    val result = new StringBuilder
    var prev = 0
    for(m <- varPat.findAllMatchIn(expr)) {
      val group = m.group(0)
      val value = group.substring(2, group.length-1)
      println(group)
      var substitute = getSubstitute(value)
      if(substitute == null) {
        substitute = group
      }
      result.append(expr.substring(prev, m.start))
        .append(getSubstitute(value))
      prev = m.end
    }
    result.append(expr.substring(prev))

    return result.mkString
  }

  def main(args: Array[String]): Unit = {
    println(substitue("""select ${ds} from '${ds}' t '${ds}' a"""))
  }
}
