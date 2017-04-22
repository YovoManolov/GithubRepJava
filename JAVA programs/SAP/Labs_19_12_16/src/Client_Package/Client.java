/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Package;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author yovo
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket s = new Socket("127.0.0.1", 1500);
        //socket : ip ,port
        Scanner scan2 = new Scanner(System.in);
        
        
        
        //object input/outputSteam za komunikaciq mejdu server i client
        
        ObjectInputStream scan= new ObjectInputStream (s.getInputStream());
        ObjectOutputStream  printOut = new ObjectOutputStream (s.getOutputStream());
        String name;
        String egn;
        String gender;
             
        System.out.println("Hi this is client ");
        
        
        System.out.println("Enter name : ");
        name = scan2.nextLine();
         System.out.println("Enter egn : ");
        egn = scan2.nextLine();
         System.out.println("Enter gender : ");
        gender = scan2.nextLine();
        
        
        Person p = new Person(name , egn , gender);
        printOut.writeObject(p);
        printOut.writeChars("g");
        
        String result =  (String) scan.readObject();
        System.out.println("The result from the server is : " + result);
    }
}
