/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.Serializable;

/**
 *
 * @author yovo
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    
    public Person(String name,int age){
      this.name = name ;
      this.age = age ;
    }
    void print(){
        System.out.println("Name " + name + " age: " + age);   
    }
   
}
