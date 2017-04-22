/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaC_thread_CS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author yovo
 */
public class Server {
     int portNumber = 1245;
     ServerSocket ss  = null;
         
       public void runServer(){
           try{
               ss = new ServerSocket(portNumber);
           }catch(IOException e){
               System.out.println(" "+ e.getMessage() );
           }
           while(true){
               try{
                   Socket clientSocket = ss.accept();
                   
               } catch(IOException e ) {
                   System.out.println(" " + e.getMessage());
               }
           }
           
       }
    
}
