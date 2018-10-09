/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;

import static java.lang.Integer.MIN_VALUE;
import java.util.Arrays;

/**
 *
 * @author yovo
 */
/*Given an Array of numbers, find  the three elements a[i] ,a[j] ,a[k] 
(i < j <k) havinng maximal multiplication a[i]. a[j] . a[k] . Withot trying  
all posible variants .*/
public class Logic {
    
    /**
     *
     * @param array
     * @return
     */
    public  int findMax(int [] array){
       int [] myArray = array;
       int product = 1; 
       Arrays.sort(myArray);
           for(int j = myArray.length  ; j > (myArray.length - 3)  ; j-- ){
               System.out.println(myArray[j-1]);
                product *= myArray[j-1];
           } 
     
        return product;   
   }   
}
