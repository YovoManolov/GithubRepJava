/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.util.Scanner;
/**
 *
 * @author yovo
 */
public class MainRegex1{  
    public static void main (String [] args){
        
        NameValidation nv = new NameValidation();
        Scanner sc = new Scanner (System.in);
        
        String True = "The userName is valid !!!";
        String False  = "The userName is NOT valid !!!";
        boolean result ;
        
        for(;;){
          System.out.println("Please enter valid userName");
          String userName = sc.nextLine();
          
          result = nv.validateUserName(userName);
          if(result == false) {
              System.out.println(False);
              break;
            } else {
              System.out.println(True);
            }
        }
        if(sc != null){
            sc.close();
        }
     
    }
}
