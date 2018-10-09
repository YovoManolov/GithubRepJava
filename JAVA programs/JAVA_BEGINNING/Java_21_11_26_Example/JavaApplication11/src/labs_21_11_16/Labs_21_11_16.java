/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_21_11_16;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yovo
 */
public class Labs_21_11_16 {
    public static void  main(String []args){
        ArrayList <Shipment> al = new ArrayList ();
        ArrayList <Letters> listLetters = new ArrayList();
        ArrayList <PreferencedLetters> preferencedLettersList = new ArrayList();
        ArrayList <Colets> coletsList = new ArrayList();
        
        Letters l = new Letters("text","sender1","recipient1","16.11.16. sendet",false);
        Letters l1 = new Letters("text2","sender2","recipient2","16.11.13. sendet",false);
        PreferencedLetters pl = new PreferencedLetters
            (true,"text3","sender3","recipient3","16.11.12. sendet",false);
        PreferencedLetters pl1 = new PreferencedLetters
            (true,"text4","sender4","recipient4","16.11.10. sendet",false);
        Colets cl = new Colets(300,true,"sender5","recipient5","16.11.11. sendet",false);
        Colets cl1 = new Colets(400,true,"sender6","recipient6","16.11.09. sendet",false);

        al.add(l);
        al.add(l1);
        al.add(pl);
        al.add(pl1);
        al.add(cl);
        al.add(cl1);
        
        
        //It returns a positive value if obj1 is greater than obj2.
        //Otherwise, a negative value is returned.
        DateOfSendingComparator comp = new DateOfSendingComparator();
        Collections.sort(al, comp);
        
       for (Shipment s : al){
           System.out.println("text : " +s.getRecipient() +
                   " Date: " + s.getDateOfSending());
       }
        
    
    }
   
}
