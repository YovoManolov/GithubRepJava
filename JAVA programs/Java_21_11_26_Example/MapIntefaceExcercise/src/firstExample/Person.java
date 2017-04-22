/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstExample;

/**
 *
 * @author yovo
 */
public class Person {
    String name;
    int age;
    
    public Person(String name ,int age){
        this.name = name;
        this.age = age;
    }
    
    /**
     *
     * @return
     */
    public int HashCode(){
        int result = 17;
        result = result*37 + this.name.hashCode();
        result = result*37 + this.age;
        return result ;    
    }
    
}   
