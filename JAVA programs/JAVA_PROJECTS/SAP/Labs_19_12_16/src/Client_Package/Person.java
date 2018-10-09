/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client_Package;

/**
 *
 * @author yovo
 */
public class Person {
    String name;
    String egn;
    String gender;
    
    public Person (String name,String egn, String gender){
        this.name = name;
        this.egn = egn;
        this.gender = gender;
    }
    
    public String takeEgn(){
        return this.egn;
    }
    public String takeGender(){
        return this.gender;
    }
}
