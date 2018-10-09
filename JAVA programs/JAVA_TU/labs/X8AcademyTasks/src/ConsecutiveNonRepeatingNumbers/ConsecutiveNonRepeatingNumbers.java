/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsecutiveNonRepeatingNumbers;

import java.util.Arrays;


/**
 *
 * @author yovo
 */
/*For example array is such [5,4,1,6,3,2]
not  like arrays [1,4,3,1,2]  -  one is repeated
 [1,4,2,5] - 3 is missing */

public class ConsecutiveNonRepeatingNumbers {
    
    public ConsecutiveNonRepeatingNumbers(){
         
        }
     boolean IsItCorrectGiven (int [] array1) {
        int [] array2 ;
        array2 = array1;
                Arrays.sort(array2);
                for(int i = 0 ;i < array2.length - 1 ; i++){
                    if((array2[i] + 1 ) != array2[i+1]) return false;
                    if(array2[i] == array2[i+1]) return false ; 
                }
     return true;
   
     }
  
}

