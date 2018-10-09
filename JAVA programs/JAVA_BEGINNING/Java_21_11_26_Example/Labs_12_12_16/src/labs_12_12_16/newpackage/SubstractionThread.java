/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_12_12_16.newpackage;

/**
 *
 * @author yovo
 */
public class SubstractionThread implements Runnable{
    double result;
    Double [] DoubleArray;
    Thread substractionThread ;
    
    public SubstractionThread (Double []ADoubles){
        substractionThread = new Thread (this);
        DoubleArray = ADoubles;
    }
    public double substract(int i){
        result = DoubleArray[i] -  DoubleArray[i+1];
        return result;
    }
    @Override
    public void run() {
        for(int i = 0;i < DoubleArray.length - 1 ;i++ ) {
           result = substract(i); 
           System.out.println("reuslt of substraction = " + result);
        }
    }
   
}
