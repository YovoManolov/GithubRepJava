package javaC_thread_CS;

import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yovo
 */
public class WritingThread implements Runnable{
     Scanner sc;
     FileWork fw ;
     public WritingThread() {
         try{
            sc = new Scanner(System.in); 
            System.out.println("Enter your String to be saved in the file : ");
         }catch(IOException e){
             System.out.println(" " + e.getMessage());
         }
     }
     
     public void writeInFile(){
         System.out.println("Enter your String to be saved in the file : ");
         fw.bw.write(sc.next());
     }
     @Override
     public void run(){
         
     }
}
