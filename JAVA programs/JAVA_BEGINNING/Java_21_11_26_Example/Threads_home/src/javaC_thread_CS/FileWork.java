/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaC_thread_CS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yovo
 */
public class FileWork {
    
     File f ;
     BufferedWriter bw ;
     BufferedReader br ;
     String readedLine ;
    
     public FileWork() throws IOException {
          f = new File ("workToDo.txt");
          bw = new BufferedWriter(new FileWriter(f));
          br = new BufferedReader (new FileReader(f));
     }
        
     public synchronized String readFromFile() throws IOException{
         readedLine = br.readLine();
         return readedLine;
     }
     public synchronized void readFromFile(String toWrite) throws IOException{
         bw.write(toWrite);
     }
             
}
