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
public class Test2 {
    public static void main(String[] args) {
        MyThreads ob = new MyThreads();
        Thread th = new Thread(ob,"SecondThread");
         th.start();
        System.out.println("This is the main Thread");
    }
}
