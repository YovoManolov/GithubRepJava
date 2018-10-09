/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex2;

import java.util.regex.*;

/**
 *
 * @author yovo
 */
public class RegexDemo2 {
    
    public static void main (String []args){    
        
    String text = "This is the text to be searched " + 
            "for occurences of the  http:// pattarn.";
    
    String patternString = ".*http: //.* ";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(text);
    boolean matches = matcher.matches();   
    }
}
