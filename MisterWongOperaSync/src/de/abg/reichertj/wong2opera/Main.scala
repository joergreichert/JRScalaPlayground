/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.abg.reichertj.wong2opera

object Main {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    // val operaAdrFileName = "/Users/jre/InstallierteProgramme/Gemeinsam/101229.adr"
    // val operaContent = scala.io.Source.fromFile(operaAdrFileName).mkString
    // OperaURLExtractor.apply(operaContent) foreach println
    val wongHtmlFileName = "/Users/jre/InstallierteProgramme/Gemeinsam/mister_wong_export.html"
    val wongContent = scala.io.Source.fromFile(wongHtmlFileName).mkString
    val elem : scala.xml.Elem = <root> { wongContent } </root>
    elem match {
      case <root><DL><p>{dts @ _*}</p></DL></root> =>
        println(dts)
            for (dt @ <DT>{_*}</DT> <- dts) {
              println(dt)
            }
      case _ => 
    }

    println(elem \\ "DT")
    WongURLExtractor.apply(wongContent) foreach println
  }
}
