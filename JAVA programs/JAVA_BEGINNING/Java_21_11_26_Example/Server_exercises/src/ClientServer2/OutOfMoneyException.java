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
class OutOfMoneyException extends Exception {
   OutOfMoneyException(){
      super("the patient has no more money");
   }
   OutOfMoneyException(double cureCost){
       super("The patient has no more money.He have to pay " + cureCost);
   }
}
