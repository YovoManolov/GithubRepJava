/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsecutiveNonRepeatingNumbers;

/**
 *
 * @author yovo
 */
public class Main {
    public static void main(String []args ){
        int [] array1 = {6,2,3,4,5,1};
        int [] array2 = {1,2,4,5,6};
        int [] array3 = {1,3,4,2,5,6,7};
        
        ConsecutiveNonRepeatingNumbers cnrn = 
                new ConsecutiveNonRepeatingNumbers();
          
          boolean result ;
          
          result = cnrn.IsItCorrectGiven(array1);
         System.out.println("Array1 : " +
                 String.valueOf(result));
         
         result = cnrn.IsItCorrectGiven(array2);
         System.out.println("Array2 : " + 
                 String.valueOf(result));
         result = cnrn.IsItCorrectGiven(array3);
         System.out.println("Array3 : " + 
                 String.valueOf(result));
    }
}
