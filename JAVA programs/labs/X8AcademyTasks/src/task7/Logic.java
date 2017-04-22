/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author yovo
 */
public class Logic {
    int c;
    void readingBy40Characters() throws FileNotFoundException, IOException{
           BufferedReader reader1 = new BufferedReader(
                       new InputStreamReader(
                           new FileInputStream("traki.txt"),
                           Charset.forName("UTF-8")));
                   System.out.println("Reading by 40 charactes in line! \n");
                    l1: while(true){
                        String str = "" ;
                        do{
                             c = reader1.read();
                             str += (char) c; 
                            if(c == -1) break l1;
                        }while(str.length() != 40);
                         System.out.println(str);
                    }
                  reader1.close();
    }
    void readingBy80Characters() throws FileNotFoundException, IOException{
        
           BufferedReader reader = new BufferedReader(
                       new InputStreamReader(
                           new FileInputStream("traki.txt"),
                           Charset.forName("UTF-8")));
                   int c;
                   System.out.println("Reading by 80 charactes in line! \n");
                   l1: while(true){
                        String str = "" ;
                        do{
                             c = reader.read();
                             str += (char) c; 
                            if(c == -1) break l1;
                        }while(str.length() != 80);
                         System.out.println(str);
                    }
                   reader.close();
                   
    }
}
