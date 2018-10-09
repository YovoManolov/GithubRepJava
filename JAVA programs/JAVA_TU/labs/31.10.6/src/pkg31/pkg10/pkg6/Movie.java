/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg31.pkg10.pkg6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author yovo
 */
public class Movie {
   
    private String name;
    private int length;
    private FileInputStream fis;
    
    Movie(String name,int lenght ,FileInputStream fis){
        this.name = name; 
        setLength(lenght);
        this.fis = fis;
    }
    public void setName(String name){
     this.name = name;   
    }
    public void setLength(int lenght) throws IllegalArgumentException {
        if(lenght < 3600){
            throw new IllegalArgumentException("Lenght is not currect set ");
        }
        this.length = lenght;
    }
    public void setFileInputStream(String FileName){
        try{
            fis = new FileInputStream(FileName);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    boolean equalThrillers(FileInputStream f1 ,FileInputStream f2){
       int c , a;
       try{
             while ((c = f1.read()) != -1){
                if(c != f2.read()){
                    return false;
                } 
            }
       }catch(IOException ex){
           System.out.println(ex.getMessage());
       }
       return true;
    }
    static int compareMovieLenghts(Movie m1, Movie m2){
        //връща -1 ако m1 е с по-голяма продължителност от m2, 
        //0 ако са равни по продължителност или 1 ако m2 е по-дълъг от m1.
        if (m1.length > m2.length) return -1;
        else if (m1.length == m2.length) return 0;
        return 1;
  
    }
    int compareWith(Movie m){
       boolean equalNames;
       int valueOfLenght;
        equalNames = this.name.equals(m.name);
        valueOfLenght = compareMovieLenghts(this, m);
        
        if(valueOfLenght == 0 && equalNames == true){
            return 0;
        }
        else return -1;
    }
}
