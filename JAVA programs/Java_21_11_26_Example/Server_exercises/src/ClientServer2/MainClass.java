/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yovo
 */
public class MainClass {
    private static ArrayList <Debtor> debtors = 
            new   ArrayList <Debtor>();
    static void addDebtor(Debtor d){
        debtors.add(d);
    }   
    
    static void printDebtors(Debtor d){
       d.print();
    }
    public static void main(String[] args){
        MedicalRoom mr = new MedicalRoom(1,"Ivan Ivanov");
        HospitalRoom hr = new HospitalRoom(2, "Petar Petrov");   
        GPOffice gp = new GPOffice(mr,hr);
        
        System.out.println("Starting server");
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException ex) {
            System.out.println("Can'start server");
            return;
        }
        System.out.println("Server started");
        
        while(true){
            Socket s = null;
            ObjectInputStream sin = null;
            ObjectOutputStream sout = null;
            
            try{
                System.out.println("Waiting for client");
                    s = serverSocket.accept();
                    sin = new ObjectInputStream(s.getInputStream());
                    System.out.println("Client connected");
                    Object o = sin.readObject();
                    if(!( o instanceof Patient)){
                        System.out.println("The object isn't instance"
                                + " of patient");
                        s.close();
                        continue;
                    }
                    Patient p = (Patient) o;
                    System.out.println(p.name + " entered");
                        
                    sout = new ObjectOutputStream(s.getOutputStream());
                    sout.flush();
                    if(!gp.nextPatient(p)){
                        Report r = new Report(p);
                        r.message = "We cannot cure  " + p.name;
                        sout.writeObject(r);
                        sout.flush();
                        s.close();
                        continue;
                    }
                    
                    while(hr.hasMorePatients()){
                        Report r =  = hr.nextPatient();
                        if(r.debt>0) addDebtor(new Debtor(r.patient, r.debt));
                        gp.logReport(r.patient, r);
                        if(r.patient.isSick() && r.patient.paycheck>0) mr.queuePatient(r.patient);
                      }

                      // First pass MedicalRoom
                      while(mr.hasMorePatients()){
                        Report r = mr.nextPatient();
                        if(r.debt>0) addDebtor(new Debtor(r.patient, r.debt));
                        gp.logReport(r.patient, r);
                      }        

                      sout.writeObject(gp.reports.get(p));
                      sout.flush();
                      s.close();
                    
                } catch (IOException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        }
        
    }
    
}
