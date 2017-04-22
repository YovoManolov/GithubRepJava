/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_package;


import Client_Package.Person;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Server {
    public static void main(String[] args) {
        try {   
        //serverSocket
        //Socket :acceptva ServerSocketa
        //object input/outputSteam za komunikaciq mejdu server i client
        ServerSocket ss = new ServerSocket(1500);
        Socket s = ss.accept();
        ObjectInputStream scan= new ObjectInputStream (s.getInputStream());
        ObjectOutputStream printOut = new ObjectOutputStream (s.getOutputStream());
        Person p;
        
            System.out.println("Hi this is server");
            try {
                p = (Person) scan.readObject();
                char request;
                request = scan.readChar();
                if(request == 'g'){
                    printOut.writeObject(p.takeGender());
                }else{
                    printOut.writeObject(p.takeEgn());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }      
        }catch(IOException e){
            System.out.println("IOException : " + e.getMessage());
        }
     
    }
}
