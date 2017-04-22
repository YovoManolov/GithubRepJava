/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_17_11;

/**
 *
 * @author yovo
 */
public class Provider {
    private String name;
    private String phoneNumber;
     
    /**
     *
     * @param name
     * @param phoneNumber
     */
    public Provider(String name,String phoneNumber){
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }
    String getName(){
        return this.name;
    }
    void setName(String name){
        this.name = name;
    }
    String getPhoneNumber(){
        return this.phoneNumber;
    }
    void setPhoneNumber(String phoneNumber){
       this.phoneNumber = phoneNumber;
    }    
}
