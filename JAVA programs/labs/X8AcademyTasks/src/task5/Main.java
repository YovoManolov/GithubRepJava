/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

/**
 *
 * @author yovo
 */
public class Main {
    public static void main(String []args){
        Logic l = new Logic();
        int [] result ;  
        int [] array = {1,3,7,6,1};
        result = l.checkNumbers(array);
        System.out.println("");
        for(int i :result) {
            System.out.print("" + i);   
        }      
    }
}
