 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;


public class Concert extends Event {
    private String starName;
    
    //John Smith*Arena Armeec*15.11.2015*20:00*20000*50*
    public Concert (String place, String date, String startHour, int numberOfTicket, double priceOfTickets,String starName) {
        super (place,date,startHour,numberOfTicket,priceOfTickets);
        this.starName = starName;
    }

    public void setStarName(String starName){
        this.starName = starName;
    }
    public String getStarName(){
        return this.starName;
    }
    
    @Override
    boolean sellTickets(int num) throws NoMoreTicketsException {
        if(numberOfTickets >= num){
            numberOfTickets += num;
            return true;
        }else throw new NoMoreTicketsException("There are no mo tickets !!! ");
    }
    
}
