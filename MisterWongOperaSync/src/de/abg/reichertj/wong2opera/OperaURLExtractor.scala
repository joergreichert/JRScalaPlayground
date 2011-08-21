/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.abg.reichertj.wong2opera

object OperaURLExtractor {
  private val regexStr = """#URL\s*ID=(.*)\s*NAME=(.*)\s*URL=(.*)\s*CREATED=(.*)[\s*DESCRIPTION=(.*)]?\s*UNIQUEID=(.*)"""
  private val regex = new util.matching.Regex(regexStr)

  def apply(operaAdrContent : String) = {
    val result = regex.findAllIn(operaAdrContent).matchData
    for {
      m <- result
    } yield createOperaURL(m.subgroups)
  }

  def createOperaURL(in : List[String]) : OperaURL =
    if(in.size == 6) new OperaURL(in(0), in(1), in(2), in(3), in(4), in(5))
    else if(in.size == 5) new OperaURL(in(0), in(1), in(2), in(3), null, in(4))
    else throw new IllegalArgumentException("Only " + in.size + " elements.")
}
