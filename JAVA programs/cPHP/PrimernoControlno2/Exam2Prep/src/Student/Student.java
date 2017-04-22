/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Student {
    /*  
    String name;
    double success;
    double incomPerPerson;
    String faculty;
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.next();
        System.out.println("Please enter your average success: ");
        double success = sc.nextDouble();
        System.out.println("Please enter average incom per person : ");
        double incomPerPerson = sc.nextDouble();
        System.out.println("Please enter your faculty: ");
        String faculty = sc.next();
        System.out.println("Please enter the doctype ");
        String doctype = sc.next();
       
        Document doc  = new Document(name,success,incomPerPerson, faculty);
        
        ObjectInputStream oin ;
        ObjectOutputStream out ;
        try {
             Socket s = new Socket("localhost",5000);
             oin = new ObjectInputStream(s.getInputStream());
             out = new ObjectOutputStream(s.getOutputStream());
             
             out.writeObject(doctype);
             out.flush();
            String respond  = (String)oin.readObject();
            if(!respond.equals("OK")){
                System.out.println("You have sended unexisted type of document"
                        + "to the server");
            }
            out.writeObject(doc);
            out.flush();
            System.out.println((String)oin.readObject());
            
        } catch (IOException ex) {
            System.out.println("Cannot connect !!! ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     
}
