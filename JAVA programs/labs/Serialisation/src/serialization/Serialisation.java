/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author yovo
 */
public class Serialisation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person p = new Person("Name",20 );
        
        try{
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(new File("newfile.txt")));
            objOut.writeObject(p);
            objOut.flush();
            objOut.close();
        }catch(FileNotFoundException e ){
            System.out.println(e.getMessage());
        }catch(IOException e ){
            System.out.println(e.getMessage());
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("newfile.txt"))){
            Object o = in.readObject();
            if(!(o instanceof Person)){
              System.out.println("Прочетения обект не е Person");
              return;
            }
            Person restored = (Person)o;
            restored.print();
            in.close();
        }catch(IOException e1){
          System.out.println("Проблем при десериализацията "+e1.getMessage());
        }
        catch(ClassNotFoundException e2){
          System.out.println("Прочетен е непознат обект "+e2.getMessage());    
        }
    }
}
