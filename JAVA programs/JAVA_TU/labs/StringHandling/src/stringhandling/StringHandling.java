/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringhandling;

import java.util.Scanner;

/**
 *
 * @author yovo
 */
public class StringHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = new String(sc.nextLine());
      IsPalindrome MIP = new IsPalindrome();
      if(MIP.isPalindrome(str)){
          System.out.println("The String : " + str + " is palindrome !!!");
      }else System.out.println("The String is not palindrome !!!");
      sc.close();   
    }
    
}
