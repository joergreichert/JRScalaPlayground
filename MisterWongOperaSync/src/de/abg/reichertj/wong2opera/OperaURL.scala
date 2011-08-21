/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.abg.reichertj.wong2opera

class OperaURL (id : String, name : String, url : String, created : String,
                description : String, uniqueId : String) {
  

  override def toString : String = name + ": " + url
}
