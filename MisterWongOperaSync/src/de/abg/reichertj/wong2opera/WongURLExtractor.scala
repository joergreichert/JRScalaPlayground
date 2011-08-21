/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.abg.reichertj.wong2opera

object WongURLExtractor {
  private val regexStr = """<DT><A HREF="(.*)" ADD_DATE="(.*)" LAST_MODIFIED="(.*)" TAGS="(.*)">(.*)</A></DT>\s<DD>(.*)</DD>"""
  private val regex = new util.matching.Regex(regexStr)

  def apply(wongContent : String) = {
    val result = regex.findAllIn(wongContent).matchData
    for {
      m <- result
    } yield createWongURL(m.subgroups)
  }

  def createWongURL(in : List[String]) : WongURL =
    if(in.size == 6) new WongURL(in(0), in(1), in(2), in(3), in(4), in(5))
    else throw new IllegalArgumentException("Only " + in.size + " elements.")
}
