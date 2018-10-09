/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

/**
 *
 * @author yovo
 */
class Debtor {
   private static final long serialVersionUID = 5L;
    Patient p;
   Double debt;
   Debtor(Patient p, Double debt){
      this.p = p;
      this.debt = debt;
   }
   public void print(){
      System.out.println("Name: " + this.name + " -> owes : " + this.debt);
   }
}
