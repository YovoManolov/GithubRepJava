/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_21_11_16;

/**
 *
 * @author yovo
 */
public class People {
    private String name;
    private String address;
    private String phoneNumber; 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(phoneNumber == null){
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * @throws NullPointerException
     */
    public void setAddress(String address) throws NullPointerException {
        if(phoneNumber == null){
            throw new NullPointerException();
        }
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null){
            throw new NullPointerException();
        }
        this.phoneNumber = phoneNumber;
    }

    
}
