/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concatNumbs;

import java.util.Arrays;

/**
 *
 * @author yovo
 */
//24 , 18 , 302 ,189 ,97 //
// 973022428918
public class Logic {
    
    StringBuilder concatNumbers(int [] array){
        int [] myArray = array;
        int length = myArray.length ;
        StringBuilder str = new StringBuilder(); 
        
         int [] arrayOfFirstNumbers = new int[length];
         int [] unsortedArray = new int[length];
         int [] arrayOfIndexes = new int[length];
       
         arrayOfFirstNumbers =  getArrayIndexes(myArray);
         
       
         for(int i = 0 ; i < length ; i ++ ){            
            unsortedArray[i] = arrayOfFirstNumbers[i];
         }
          
  
         Arrays.sort(arrayOfFirstNumbers); 
         
        /* 
                //arrayOfFirstNumbers
                 for(int i = 0; i < length ;i++ ){      
                    System.out.println(arrayOfFirstNumbers[i]);
                }
                 System.out.println("");    

                  ///unsortedArray[i]
                for(int i = 0; i < length ;i++ ){      
                   System.out.println(unsortedArray[i]);
                }
         */ 
     
       
        for(int i = 0; i < length ;i++ ){
            for(int b = 0 ;b < length ; b++){
                if(arrayOfFirstNumbers[i] == unsortedArray[b]){
                 arrayOfIndexes[i] = b; 
                }  
            }
           
        }
       /*  for(int i = 0; i < length ;i++ ){      
             System.out.print(arrayOfIndexes[i]);
            }
        */
        System.out.println("");
        
        String str1 ;
        
        for(int i = length - 1 ; i >= 0 ; i -- ){
            int a = arrayOfIndexes[i];
            str1 = String.valueOf(myArray[a]);
            str.append(str1);
        }
     return str; 
   }
    
    int getFirstNumber(int number){
        int firstNumber = 0;
        if(number < 10){
            firstNumber = number;
        }         
        if(number < 100){
            firstNumber  = (int) number /10 ;
        }
        else if(number < 1000){
           firstNumber  = (int) number /100 ;
        }
        return firstNumber;
    }
    
    int [] getArrayIndexes(int [] myArray){
        int [] arrayOfFirstNumbers1 = new int[myArray.length];
        
        for(int i = 0 ;i < myArray.length ; i ++ ){
           int   a = getFirstNumber(myArray[i]);
           arrayOfFirstNumbers1[i] = a;
        }
        return arrayOfFirstNumbers1;
    }
   
}
