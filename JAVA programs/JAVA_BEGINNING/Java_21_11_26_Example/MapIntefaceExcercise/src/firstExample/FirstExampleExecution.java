/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstExample;

/**
 *
 * @author yovo
 */
public class FirstExampleExecution {
   public static void main(String []args){
       Person philip =  new Person("Philip Petrov",37);
       Subject PIK3 = new Subject("PIK3",philip);
       Subject bd = new Subject("Bazi Danni",philip);
       
       Student yovo = new Student("Yovo Manolov",20,"121215172");
       yovo.setGrade(PIK3, StandartGrade.MNOGO_DOBYR);
       yovo.printGrade(PIK3);
       yovo.printGrade(bd);
       yovo.setGrade(PIK3, StandartGrade.OTLICHEN);
       yovo.printGrade(PIK3);
      
       
   }           
}
