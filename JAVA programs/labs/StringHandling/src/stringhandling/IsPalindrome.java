/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringhandling;

/**
 *
 * @author yovo
 */
public class IsPalindrome {
   boolean isPalindrome (String str ) {
       if(str.length() == 0 || str.length() == 1){
           return true;
       }
       else{
           if(str.charAt(0) == str.charAt(str.length()-1)){
             IsPalindrome IP = new IsPalindrome();
                 return IP.isPalindrome(str.substring(1,(str.length()- 1)));
           }
           return false;
       }
   }
}
