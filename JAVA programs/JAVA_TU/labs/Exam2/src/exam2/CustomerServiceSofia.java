/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import static exam2.CustomerService.ll;
import java.util.Random;

/**
 *
 * @author yovo
 */
public class CustomerServiceSofia extends CustomerService {
    private final String city;
    private String municipality;

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    public CustomerServiceSofia (PropertyInquiry pi, int ticketOfficeNumber
            , Employee e, int entryNumber,String manicipality) {
        super(pi, ticketOfficeNumber, e, entryNumber);
        this.city = "Sofia";
        this.setMunicipality(municipality);
    }

    public CustomerServiceSofia() {
        super(null, 0, null, 0);
        this.city = null;
    }

    static int addInquiry(PropertyInquiry pi){
        if(pi.getCity().equalsIgnoreCase("sofia")){
            System.out.println("The cities are the same");
        }else System.out.println("different cities");
        
        Random rd =  new Random();
        int entryNumber = 5;
        pi.setEntryNumber(entryNumber++);
        ll.add(pi);
        return entryNumber; 
    }
}
