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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class StudentThread extends Thread {
    /*тази нишка трябва да се свърже със клиентът студент и да попълни 
    декларацията , за да я добави с списъка с декларации*/
    Socket s ;
    StudentThread(Socket s){
     this.s = s;
    }
    @Override
    public void run(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject("Please choose type of Declaration you wont to make");
            
            ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
            String doctype = (String)oin.readObject();
            if(doctype.equals("normal")||doctype.equals("special")){
                out.writeObject("OK");
                out.flush();
            }else{
                out.writeObject("Bad type");
                out.flush();
                s.close();
                return;
            }
            Document doc;    
            doc = (Document) oin.readObject();
            switch (doctype) {
                case "normal":
                    Server.normalDocuments.add(doc);
                    out.writeObject("your document is added "
                            + "to normal documents");
                    out.flush();
                    break;
                case "special":
                    Server.specialDocuments.add(doc);
                    out.writeObject("your document  is added "
                            + "to special documents");
                    out.flush();
                    break;
                default:
                    out.writeObject("Some mistake going on !!!");
                    out.flush();
                    s.close();
                    break;
            }
           
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
