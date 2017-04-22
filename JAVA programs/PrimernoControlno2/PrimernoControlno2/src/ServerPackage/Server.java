/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;

import Student.Application;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Server {
    public static void main(String[] args) {
        try {
             ServerSocket ss = new ServerSocket(1600);
             Socket s = ss.accept();
             ObjectInputStream obis = new ObjectInputStream
                                                    (s.getInputStream());
             ObjectOutputStream obos = new ObjectOutputStream
                                                    (s.getOutputStream());
             Scanner sc = new Scanner(System.in);
             
             Secretary secr1 ; 
             Secretary secr2 ;
            
              List<Application> listOfApplicationsBeforeTheCheck
                        = new LinkedList <>();
                
              List<Application> listOfApplicationsAfterTheCheck
                        = new LinkedList <>();
              
                System.out.println("Hi this is Server");
                System.out.println("Please select one from the "
                                                 + "following opportunities");
                System.out.println("1.Apply for scholarship for success");
                System.out.println("2.Apply for special scholarship");
            
                obos.writeObject(sc.next());
                Application a;
                while(true){
                    a = (Application)obis.readObject();
                    if(a == null)break;
                    listOfApplicationsBeforeTheCheck.add(a);
                }
                
            for(int i = 0 ; i < listOfApplicationsBeforeTheCheck.size();i++ )
                    a = listOfApplicationsBeforeTheCheck.get(i);
                    secr1 = new Secretary(a);
                    if(secr1.isAlive()){
                        secr2 = new Secretary(a);
                        secr2.join();
                        listOfApplicationsAfterTheCheck.add(a);
                        listOfApplicationsBeforeTheCheck.remove(a);
                    }
                    secr1 = new Secretary(a);
                    secr1.start();
                    listOfApplicationsAfterTheCheck.add(a);
                    listOfApplicationsBeforeTheCheck.remove(a);
                    
         
        } catch (IOException | ClassNotFoundException | InterruptedException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
