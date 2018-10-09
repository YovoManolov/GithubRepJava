/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread_Runnable;

/**
 *
 * @author yovo
 */
public class MyThreads implements Runnable{
   void print(){
       System.out.println("this is the thread of MyThread ");    
   }
   
   @Override
   public void run(){
    this.print();
   }
}