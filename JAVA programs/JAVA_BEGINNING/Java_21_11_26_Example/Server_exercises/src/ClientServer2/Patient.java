/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author yovo
 */
public class Patient implements Serializable{
    private static final long serialVersionUID = 5L;
    String name;
    String egn;
    double paycheck;
    ArrayList <Diagnosis> sicknesses =  new ArrayList <Diagnosis> ();
    
    public Patient(String name,String egn,double paycheck,ArrayList sicknesses){
        this.name = name;
        this.egn = egn;
        this.paycheck = paycheck;
        this.sicknesses = sicknesses;
    }

    
    /*Реализирайте метод “private double payBill(double amount)”, който намалява paycheck с amount и:
    Ако paycheck все още е положителен, връща 0 (човека е платил и не сължи нищо);
    Ако paycheck е станал отрицателен, трябва да направи paycheck 0 (човека е платил каквото има),
    а да върне като резултат колко пари дължи (с колко amount е бил по-голям от paycheck).
    */
    private double payBill(double amount){
        double owning = 0;
        paycheck -= amount ;
         if(paycheck > 0){
             return 0;
        }
        if((paycheck - amount) < 0){   
            return amount - paycheck;
        }
        return owning;
    }
    /*
    Ако човекът вече няма пари (paycheck е станал <=0 след последното
    лечение или не е имал пари по принцип), хвърля OutOfMoneyException;
    Ако подаденото заболяване не съществува в списъка от болести на
    човека (той не е болен от него), хвърля NoSuchSicknessException;
    Ако има такава болест и има позитивен
    баланс, прави return this.payBill(sickness.cureCost);
    */

    /**
     *
     * @param sickness
     * @return
     * @throws OutOfMoneyException
     * @throws NoSuchSicknessException
     */

    public double cureSickness(Diagnosis sickness)
            throws OutOfMoneyException,NoSuchSicknessException {
        if(paycheck <= 0){
            throw new OutOfMoneyException();
        }
        if(!sicknesses.contains(sickness)){
           throw new NoSuchSicknessException();
        }else return this.payBill(paycheck); 
    }
}
