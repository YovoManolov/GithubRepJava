/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author yovo
 */
public class NameValidation {

   private final Pattern p;
   private  Matcher m;
  /*Може да съдържа букви от a-z малки;
    Може да съдържа и цифрите от 0-9;
    Може да съдържа долна черта или тире;
    Може да бъде с дължина от 3 до 15 символа.*/
   private static final String USERNAME_PATTERN = "^[\\w+(\\.)?]@[a-z]{3}\\.\\w{2}$" ;
   
   
   public NameValidation(){
       p = Pattern.compile(USERNAME_PATTERN);
   }
    
  public boolean validateUserName(final String isValid){
      m = p.matcher(isValid);
        return m.matches();
  } 
   
 
}
