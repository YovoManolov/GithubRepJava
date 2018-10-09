/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yovo
 */
public class Main {
    public static void main(String [] args) throws IOException {
         Logic l = new Logic();
              try {
                 l.readingBy80Characters();
                 l.readingBy40Characters();
              }catch (FileNotFoundException e){
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
              }catch (IOException e){
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
              }              
    }
    
}   