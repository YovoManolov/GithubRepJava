/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs_12_12_16;
import java.util.Arrays;
/**
 *
 * @author yovo
 */
//2 nishki :
//1rva promenq masiva с числа( x*10)
// 2ра стартира 

// 2 метода : 1рви променя масива 
// 2ри метод сортира масива 

// 2 класа нишки 
// 1дин за промяна 2ри за сортиране
public class ArrayClass {
    int [] IntArray  = {5,4,3,2,1};
    void sortArray(){
        Arrays.sort(IntArray);
    }
    void DifferentArray (){
        for(int i =0 ; i< 5 ;i++){
            IntArray[i] *= 10;
        }
    }
    void printArray(int[]array){
        System.out.println("");
        
       for(int i = 0 ; i < 5 ; i++){
           System.out.print(" // "+ array[i]);
       }
    }
}
