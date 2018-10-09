/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author yovo
 */
public class MedicalRoom {
     int number;
        String doctor;
        LinkedList<Patient> queue;
        // От какво се лекува пациента в MedicalRoom
        Diagnosis [] cureFrom;

        MedicalRoom(int number, String doctor){
          this.number = number;
          this.doctor = doctor;
          this.queue = new LinkedList<>();
          cureFrom = new Diagnosis[]{Diagnosis.NOTSICK, Diagnosis.LITTLESICK};
        }

        void queuePatient(Patient p){
          // Добавяме пациент в края на списъка
          this.queue.addLast(p);
        }

        // Ако хвърли изключение, опашката е празна
        boolean nextPatient() throws NoSuchElementException{  
          // Взимаме първия пациент от списъка
          Patient p = this.queue.getFirst();
          for(Diagnosis sickness: this.cureFrom){
            try{
              double debt = p.cureSickness(sickness);
              System.out.println(p.name+" was cured from "+sickness.toString());
              if(debt>0){
                MainClass.addDebtor(new Debtor(p, new Double(debt)));
                System.out.println(p.name+" was put in the list of debtors with debt "+debt);
              }
            }
            catch(OutOfMoneyException oe){
              System.out.println(p.name+" has no money to pay for "+sickness.toString());
              break;
            }
            catch(NoSuchSicknessException nse){}
          }
          // Премахваме го от опашката
          queue.removeFirst();
          // Проверяваме дали човека все още е болен от нещо
          for(Diagnosis sickness: Diagnosis.values()){
            if(p.sicknesses.contains(sickness)) return true;
          }
          return false;
        }

        boolean hasMorePatients(){
          return !this.queue.isEmpty();
        }
}


