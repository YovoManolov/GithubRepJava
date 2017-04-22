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
public class NoSuchSicknessException extends Exception {
    NoSuchSicknessException(){
        super("The patient isn't sick from this disease");   
    }
      NoSuchSicknessException(Diagnosis sickness){
        super("Пациентът нe е болен от тази болест: " + sickness.toString());
      }
}
