/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yovo
 */
public class ConnectionThread extends Thread {
    ServerSocket ss;
    boolean isStudentAccepter;
    ConnectionThread(int port,boolean isStudentAccepter ) throws IOException{
       ss = new ServerSocket(port);
    }
    @Override
    public void run(){
       while(true){
        try { 
           Socket s = ss.accept();
           Thread t;
           
           if(this.isStudentAccepter){
               System.out.println("Student connected");
               t = new StudentThread(s);
           }else{
               System.out.println("Secretary connected"); 
               t = new SecretaryThread(s);  
           }
           t.start();
          
       } catch (IOException ex) {
          Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
  }
}

