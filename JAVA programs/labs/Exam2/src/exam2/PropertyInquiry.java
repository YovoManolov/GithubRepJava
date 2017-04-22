/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

/**
 *
 * @author yovo
 */
/*
a) Име на текущия собственик;
б) Име на новия собственик;
в) Уникален номер на имота;
г) Град, в който се намира имота;
д) Входящ номер на молбата.

Напишете конструктор с подадени параметри и get методи. Напишете set 
метод за входящия номер, а останалите данни защитете така,
че да не могат да бъдат променяни. Входящият номер 
първоначално да се инициализира със служебна стойност 0.
*/
public class PropertyInquiry {
   final private String currentOwner = "owner1" ;
   final  private String nextOwner = "owner2" ;

   final  private long number = 123 ;
   final private String city = "Sofia ";
   private int entryNumber ;
    ///Constructor 
    public PropertyInquiry(int eNumb) {
        this.setEntryNumber(eNumb);
        entryNumber = 0;
    }
    
    
         public String getNextOwner() {
            return nextOwner;
        }

        public long getNumber() {
            return number;
        }

        public String getCity() {
            return city;
        }

        public int getEntryNumber() {
            return entryNumber;
        }

        public String getCurrentOwner(){
           return this.currentOwner;
        }
    /**
     *
     * @param eNumb
     */
        
    public void setEntryNumber(int eNumb){
       this.entryNumber = eNumb;
    }
}
