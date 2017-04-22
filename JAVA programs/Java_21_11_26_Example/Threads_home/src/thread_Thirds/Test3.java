/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_Thirds;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Test3 {
    public static void main(String[] args) {
       int  i ;
       MyThread3 mt3 =  new MyThread3 ();
       Thread mainThread = new Thread (mt3,"mainThread");
       mainThread.start();
       try{
            for(i=0 ;i <10 ;i++){
                System.out.println("This is mainThread " + i);
                mainThread.sleep(70);
            }
       }catch (InterruptedException ex) {
                 Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }  
}
 class MyThread3 implements Runnable{
     void print(int i){
         System.out.println("Thread conunter : " + i);   
     }
     @Override
     public void run ()  {
         int i;
         try {
            for (i = 0 ; i < 10  ; i++){
                Thread.sleep(150);
                this.print(i);          
            }
         } catch (InterruptedException ex) {
                 Logger.getLogger(MyThread3.class.getName()).log(Level.SEVERE, null, ex);
             }
     }
 }
