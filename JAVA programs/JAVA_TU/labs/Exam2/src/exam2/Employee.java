package exam2;


import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yovo
 */
/*а) Име;
б) ЕГН;
в) Номер на отдел.
*/
public class Employee {
   private String name;
   private String egn;
   private int sectionNumber;

    /**
     *
     * @param egn
     * @param name
     * @param sectionNumber
     */
    public Employee(String egn,String name,int sectionNumber){
       this.setEgn(egn);
       this.setName(name);
       this.setSectionNumber(sectionNumber);
   }
   
        
        /**
         *
         * @return
         */
        public String getName(){
                return this.name;
            }

        /**
         *
         * @return
         */
        public String getEgn(){
                return this.egn;
            }

        /**
         *
         * @return
         */
        public int getSectionNumber(){
                return this.sectionNumber;
            }

         /**
         *
         * @param sectionNumber
         */
        public void setSectionNumber(int sectionNumber) {
            this.sectionNumber = sectionNumber;
        }
        public void setName(String name){
               this.name = name; 
            }
            public void setEgn(String egn) throws InvalidParameterException{
               if(validateEgn(egn)){
                   this.egn = egn;
               }else {
                   throw new  InvalidParameterException("Invalid egn");
               }
            }
        
   boolean validateEgn(String egn){
       Pattern p = Pattern.compile("[0-9]{10}");
       Matcher m = p.matcher(egn);           
       return m.matches();
   }    
}
