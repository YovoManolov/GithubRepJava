/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_12_12_16;

/**
 *
 * @author yovo
 */
public class Thread1 implements Runnable {
  
   ArrayClass ac =  new ArrayClass();
   Thread t1 ;
   public Thread1 (ArrayClass ac){
       this.ac = ac;
       t1 = new Thread(this);
   }
   
    @Override
   public void run(){
     ac.DifferentArray();
     ac.printArray(ac.IntArray);
   }
}