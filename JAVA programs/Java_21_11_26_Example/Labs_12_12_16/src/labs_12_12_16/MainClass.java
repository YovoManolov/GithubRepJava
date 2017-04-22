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
public class MainClass {
    public static void main(String[] args) {
        ArrayClass ac = new ArrayClass();
       
        Thread2 t2 = new Thread2(ac);
        Thread1 t1 = new Thread1(ac);
        
        t1.t1.start();
        t2.t.start();
    }
}
