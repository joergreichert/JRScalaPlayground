package de.abg.reichertj.loadassigner


object Main {
  def main(args : Array[String]) : Unit = {
    val controlTypeID = new scala.util.matching.Regex(""".*controlTypeID="(.[^"]*)".*""")
    val lines = scala.io.Source.fromFile("all.xml").getLines().toList
    val values = scala.collection.mutable.Set.empty[String]
    lines foreach(l => for(controlTypeID(s) <- controlTypeID findAllIn l) values.add(s))
    val nameCompare = new Ordering[String] {
      def compare(s1 : String, s2 : String) = s1.compareToIgnoreCase(s2)
    }
    val sortedValues = scala.collection.immutable.TreeSet.empty[String](nameCompare) ++ values
    sortedValues map(_.replace("com.balsamiq.mockups::"), "") foreach(v => println(v))
  }
}