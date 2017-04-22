/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_17_11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yovo
 */
public class ProductWriter {
    /*който чрез BufferedWriter записва информацията във формат:
    No#ИмеДоставчик#ТелефонДоставчик#Инв.Номер#ПромоционалнаЦена
    #Производител/Авто#Модел/Заглавие# */
    static void saveInFile(Product[] products) throws IOException{
            File f  = null;
            FileWriter fw = null;
            BufferedWriter bw = null;
        try{
            f = new File("salesproducts.txt");
            fw =  new FileWriter(f);
            bw = new BufferedWriter(fw);
            for(Product p : products){
                     if(p instanceof Electronics ){
                           String toWrite;
                         Electronics e = (Electronics) p;
                         toWrite = new String(1 +"#"
                                 + p.getProvider().getName() +
                     "#"+e.getProvider().getPhoneNumber()
                                 +"#" + e.getInventNumb() +
                       "#" + e.getPromotionalPrice() + "#" 
                                 + e.getManufacturer() +"#" 
                                 + e.getModel()+"#");
                         System.out.println(toWrite);
                          bw.write(toWrite);
                         bw.write("\n");
                    }
                     if(p instanceof Book ){
                          String toWrite;
                        Book b = (Book)p;
                       toWrite = new String("#" +
                                2 +"#" + b.getProvider().getName() +
                                "#"+b.getProvider().getPhoneNumber()+"#" +
                               b.getInventNumb() + b.getPromotionalPrice() 
                                + "#" + b.getProvider().getName() +"#" +
                               b.getAuthor() +"#"+ b.getTitle()+"#");
                        System.out.println(toWrite);
                         bw.write(toWrite);
                         bw.newLine();
                    }

           }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{ 
            try{
                 if(bw != null) bw.close(); 
            if(fw != null) fw.close();  
            }catch(IOException e){
                e.printStackTrace();
            }
        }
     }
}
