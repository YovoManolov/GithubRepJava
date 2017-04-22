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
// el_1 <= el2 >=el3 
// without to go trough all elements

// I was thinking to do it with (FIFO - Queue) data structure but the following 
// solution is also interesting 
public class Logic {  
    public int[] checkNumbers(int [] numbers){
        int [] resultArray = new int [3];
        int [] toWorkWithArray = new int[ numbers.length];
        int number1 = 0 ,number2 = 0 ,number3 = 0 ;
        
        boolean correct = false ;
        int a = 0;
        while(correct != true){
            for(int i = a ,j = 0 ;i < numbers.length ; i++ ,j++){
                toWorkWithArray[j] = numbers[i];
            }    
                    number1 = toWorkWithArray[0];
                    
                    if( toWorkWithArray[1] >= number1 ){
                        number2 = toWorkWithArray[1];
                    }else{
                        a++;
                        correct = false;
                        continue;
                    }
                    
                    if( number2 >= toWorkWithArray[2] ){
                        number3 = toWorkWithArray[2];
                    }else{
                        a++;
                        correct = false;
                        continue;
                    }
           correct = true;         
        }
        
        resultArray[0] = number1;
        resultArray[1] = number2;
        resultArray[2] = number3;
      
        return resultArray;  
    }
}
