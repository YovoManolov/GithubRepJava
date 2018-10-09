/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author yovo
 */
public abstract class Event {

    /**
     *
     */
   protected int identification;
   protected String place;
   protected String date;
   protected String startHour;
   protected int  numberOfTickets;
   protected double priceOfTickets;
   
    /**
     *
     * @param place
     * @param date
     * @param startHour
     * @param numberOfTicket
     * @param priceOfTickets
     */
    public Event (String place, String date, String startHour , int numberOfTicket ,double priceOfTickets){
        this.identification = 0;
        this.place = place;
        this.date = date;
        this.startHour = startHour;
        this.numberOfTickets = numberOfTicket;
        this.priceOfTickets = priceOfTickets;
    }
          
   abstract boolean sellTickets(int num) throws NoMoreTicketsException ;
}
