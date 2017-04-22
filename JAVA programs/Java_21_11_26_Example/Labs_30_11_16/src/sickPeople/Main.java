/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sickPeople;

import ClientServer2.OutOfMoneyException;
import ClientServer2.NoSuchSicknessException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author yovo
 */
 /* 
    Създавате няколко примерни обекта от тип Patient и ги нареждате в LinkedList;
    За всеки елемент на свързания списък правите по няколко различни лечения;
    Тези хора, които са били лекувани, но не са успяли да платят, записвате в речника debtors
    Накрая извеждате имената и сумите, които дължат, за всички длъжници в речника.
    */
public class Main{
     static HashMap <Patient, Double> 
                debtors = new HashMap<>();
    public static void main(String []args){
        ArrayList <Diagnosis> sicknesses1 =  new ArrayList <> ();
        sicknesses1.add(Diagnosis.LITTLESICK);
        Patient p = new Patient("name1","egn1",100,sicknesses1);
        sicknesses1.add(Diagnosis.SICK);
        Patient p1 = new Patient("name2","egn2",200,sicknesses1);
        sicknesses1.clear();
        sicknesses1.add (Diagnosis.SICK);
        sicknesses1.add (Diagnosis.VERYSICK);
        Patient p2 = new Patient("name3","egn3",400,sicknesses1);
        sicknesses1.clear();
        sicknesses1.add (Diagnosis.NOTSICK);
        Patient p3 = new Patient("name4","egn4",50,sicknesses1);
      
        Patient [] pArray = new Patient [4];
        
        pArray[0] = p;
        pArray[1] = p1;
        pArray[2] = p2;
        pArray[3] = p3;
         try{
              for(Patient patient : pArray){
                  double value;
                   Check c = new Check();
                    if(patient.sicknesses.size() == 2){
                        value =  patient.cureSickness(patient.sicknesses.get(0));
                        if (c.checkPayment(value)){
                            debtors.put(patient,value);
                        }
                        value =  patient.cureSickness(patient.sicknesses.get(1));
                        if (c.checkPayment(value)){
                            debtors.put(patient,value);
                        }
                     
                    }
                        value = patient.cureSickness(p1.sicknesses.get(0));
                          if (c.checkPayment(value)){
                            debtors.put(patient,value);
                        }
              } 
         }catch(NoSuchSicknessException | OutOfMoneyException e){
             e.getMessage();
         }   
      debtors.toString();
      
    }
   
}
