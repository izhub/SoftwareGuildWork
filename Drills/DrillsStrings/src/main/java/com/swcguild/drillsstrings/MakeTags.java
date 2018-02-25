/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsstrings;

/**
 *
 * @author apprentice
 */
public class MakeTags {
    
/*The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic 
    text. In this example, the "i" tag makes <i> and </i> which surround the word 
    "Yay". Given tag and word strings, create the HTML string with tags 
    around the word, e.g. "<i>Yay</i>". 
*/
//MakeTags("i", "Yay") -> "<i>Yay</i>"
//MakeTags("i", "Hello") -> "<i>Hello</i>"
//MakeTags("cite", "Yay") -> "<cite>Yay</cite>"

public String MakeTags(String tag, String content) {
    
    return "<" + tag + ">" + content + "</"+ tag + ">";

}
}
