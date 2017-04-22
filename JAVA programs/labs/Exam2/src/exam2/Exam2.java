/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

/**
 *
 * @author yovo
 */
public class Exam2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e = new Employee("3952323434" ,"Yovo",8);
        PropertyInquiry pi  = new PropertyInquiry(5523);
        PropertyInquiry pi1  = new PropertyInquiry(523);
        PropertyInquiry pi2  = new PropertyInquiry(23);
        CustomerServiceSofia  scs = new CustomerServiceSofia (pi,2, e, 42,"sofiiska");
        CustomerServiceSofia.addInquiry(pi);
        CustomerServiceSofia.addInquiry(pi1);
        CustomerServiceSofia.addInquiry(pi2);
        CustomerServiceSofia.deleteInquiry(5523);
        
        
    }
    
}
