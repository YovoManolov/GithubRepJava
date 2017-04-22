/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author yovo
 */
/*
    а) Списък със заявки – общовалиден за целия клас;
    б) Номер на гишето;
    в) Служител работещ на гишето, който е от клас Employee;
    г) Текущ пореден входящ номер на заявка – общовалиден за целия клас.

Напишете конструктор с подадени параметри, който инициализира
номера на гишето. Напишете статичен метод AddInquiry, който добавя
заявка в списъка (получава я като параметър и й задава входящ номер) 
и връща като резултат входящия номер на добавената молба. Напишете
статичен метод, който изтрива молба по подаден входящ номер.
*/
// static addInquiry(PropertyInquiry)
public class CustomerService {
    
    static LinkedList <PropertyInquiry> ll = new LinkedList();
    private final int ticketOfficeNumber ;
    private Employee e ;
    private int entryNumber ;
    
    /**
     *
     * @param pi
     * @param ticketOfficeNumber
     * @param e
     * @param entryNumber
     */
    public CustomerService (PropertyInquiry pi , int ticketOfficeNumber,
                             Employee e ,int entryNumber){
        this.setEmployee(e);
        ll.add(pi);
        this.ticketOfficeNumber = 1;
        this.setEntryNumber(entryNumber);
    
    }
    
            /**
             *
             * @return
             */
            public int getTicketOffice() {
                return this.ticketOfficeNumber;
            }

            /**
             *
             * @return
             */
            public Employee getEemployee() {
                return e;
            }

            /**
             *
             * @return
             */
            public int getEntryNumber() {
                return this.entryNumber;
            }
            /**
             *
             * @param e
             */
            public void setEmployee(Employee e) {
                this.e = e;
            }

            /**
             *
             * @param entryNumber
             */
            public void setEntryNumber(int entryNumber){
                this.entryNumber = entryNumber;
            }
            
  /*Напишете статичен метод AddInquiry, който добавя
    заявка в списъка (получава я като параметър и й задава входящ номер) 
    и връща като резултат входящия номер на добавената молба.*/
    
    static int  addInquiry(PropertyInquiry pi){
        Random rd =  new Random();
        int entryNumber = 5;
        pi.setEntryNumber(entryNumber++);
        ll.add(pi);
        return entryNumber; 
    }
    static void deleteInquiry(int entryNumber){
        int indexes = ll.size();
        for(int i = 0 ;i < indexes ;i ++ ){
            PropertyInquiry  pi = ll.get(i);
            if(pi.getEntryNumber() == entryNumber){
                ll.remove(i);
            }
        }
    }
}
