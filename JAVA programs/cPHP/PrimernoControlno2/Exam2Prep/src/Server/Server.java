/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Student.Document;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Server {
    
    private static final String password = "secret";
    public final static  LinkedList <Document> normalDocuments  = new LinkedList <>();
    public final static  LinkedList <Document> specialDocuments  = new LinkedList <>();
    public final static  HashMap <String,Integer> studentInfo = new HashMap <>();
    /**
     *
     * @param args
     */
    public static void main(String[] args)  {
         try {
            ServerSocket ss = new ServerSocket(5002);
            ConnectionThread studentT = new ConnectionThread(5000, false);
            ConnectionThread secretaryT = new ConnectionThread(5001, true);
            
            studentT.start();
            secretaryT.start();
                   
               while(true){
                   Socket s = ss.accept();
                   //trqbva da svurja survura sus studenta i s secretarkite
                   // za da si obmenqt info
                   ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
                   ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

                   out.writeObject("Please write the password");
                   if (((String) oin.readObject()).equals(password)) {
                       out.writeObject("OK");
                   } else {
                       out.writeObject("BadPassword");
                       return;
                   }

                   String nameOfStudent = (String) oin.readObject();
                   int numberOfAcceptedAplications = studentInfo.get(nameOfStudent);
                   out.writeInt(numberOfAcceptedAplications);
            }
         } catch (IOException | ClassNotFoundException ex) {
               Logger.getLogger(Server.class.getName())
                    .log(Level.SEVERE, null, ex);
         }
    }
            
 }


