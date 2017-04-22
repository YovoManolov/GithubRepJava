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


/*mislq che ne sym gi vyrzal kato horata
i na`ina po kojto trqbva da se napravqt nishkite sushto 

*/
public class Client {
    
    final static String host = "127.0.0.1";
    final static int port = 1600;      
   
    public static void main(String[] args) {
        String name;
        String typeOfApplication ;
        Double AvSuccessOfStudent; 
        Double AvIncomPerPerson;
        String faculty;
        Boolean haveSuccessScholarship = false;
        Integer numberOfSpecialScholarships;
        Boolean isApplicationTaken;
        
        try{
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket(host,port);
            ObjectInputStream obis = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream obos = new ObjectOutputStream(s.getOutputStream());
             /*Всеки студент има право да получи максимум 5 специални стипендии,
             при условие, че взима стипендия за успех и 4 специални стипендии,
             при условие, че не взима стипендия за успех.*/
             
            System.out.println("Hi this is client ");
            //variable for the messages from the server
            String messageFromSurver;
            
            Application application  = null;
            while(true){
             System.out.println("Do you want to proceed");
             if(sc.nextLine().equalsIgnoreCase("no")) 
                                            obos.writeObject(application);
             
             
             //name
             System.out.println("Enter Name : ");
             name = sc.nextLine();
             
             //typeOfApplication
             System.out.println("Enter typeOfApplication (\"success\" or "
                     + " \"special\" ) : ");
             typeOfApplication = (String) obis.readObject();
             
             //AverageSuccess Of Student
             System.out.println("Enter AvSuccessOfStudent : ");
             AvSuccessOfStudent = sc.nextDouble();
             
             //AverageIncomPerPerson
             System.out.println("AvIncomPerPerson : ");
             AvIncomPerPerson = sc.nextDouble();
             
             //faculty
             System.out.println("Enter faculty: ");
             faculty = sc.nextLine();
             
             //possesing success scholarship
             System.out.println("Do you have Scholarship for success:Enter T or F ");
             if(sc.next().equals("T")) haveSuccessScholarship = true;
             if(sc.next().equals("F")) haveSuccessScholarship = false;
             
             isApplicationTaken = false;
             
             //numberOfSpecialScholarships
             System.out.println("Enter numberOfSpecialScholarships "
                     + " between 0 and 5 : ");
             numberOfSpecialScholarships = sc.nextInt();
             
             application = new Application(name,typeOfApplication,AvSuccessOfStudent,
                     AvIncomPerPerson,faculty,haveSuccessScholarship,
                     numberOfSpecialScholarships,isApplicationTaken);
              obos.writeObject(application);
            }
            
         }catch (IOException | ClassNotFoundException ex ){
           Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }   
}
