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
public class SecretaryThread extends Thread{
    
   
    Socket s ;
    SecretaryThread (Socket s){
      this.s = s;
    }
    
    @Override
    public void run(){
        
        /*Документът се изпраща до студентската канцелария. От там решават 
        дали кандидатът отговаря на необходимите условия. В канцеларията
        работят 2 секретарки. Всяка от тях взима
        избран формуляр и съответно формулярът се отчита в 
        системата като взет, съответно заключен –изважда се
        от опашката с чакащи за одобрение формуляри.*/
        try{
            ObjectOutputStream out = new ObjectOutputStream
                                        (this.s.getOutputStream());
            out.flush();
            ObjectInputStream oin  = new ObjectInputStream(s.getInputStream());
            if(((String)oin.readObject()).equals("secret")){
            out.writeObject("OK");
            out.flush();
            }else{
                out.writeObject("Bad password");
                out.flush();
                this.s.close();
                System.out.println("Bad password for secretary connection");
            }
            
            Document doc;
            
            synchronized(Server.specialDocuments){
                if(!Server.specialDocuments.isEmpty()){
                    out.writeObject("special");
                    doc = Server.specialDocuments.getFirst();
                    out.writeObject(doc);
                    Server.specialDocuments.removeFirst();
                    System.out.println("Special document send to secretary");
                    return;
                }
            }
            
            synchronized(Server.normalDocuments){
                if(!Server.normalDocuments.isEmpty()){
                    out.writeObject("normal");
                    doc = Server.normalDocuments.getFirst();
                    out.writeObject(doc);
                    Server.normalDocuments.removeFirst();
                    System.out.println("Normal document send to secretary");
                    return;
                }
            }
            out.writeObject("no documents available");
            out.flush();
        }catch(IOException e){
            System.out.println(" " + e.getMessage()); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecretaryThread.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
