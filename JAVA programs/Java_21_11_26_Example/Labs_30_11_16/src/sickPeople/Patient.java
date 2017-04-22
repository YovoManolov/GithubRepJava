/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sickPeople;


import java.util.ArrayList;

/**
 *
 * @author yovo
 */
/*
 Реализирайте клас „Пациент” (Patient) със следните
характеристики: name (String), egn (String)
, paycheck (double – колко пари има човека) и sicknesses 
(ArrayList с елементи от изброим тип Diagnosis – какви заболявания има човека)
. Направете само конструктор с подадени параметри. Не правете
get и set методи – нека всички са с модификатор за достъп default.
*/

public class Patient {
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

    Patient(String name1, String egn1, int i, Diagnosis d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
