/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

public class VolleyBallMatch extends Event {
    private String firstTeam;
    private String secondTeam;
    
   public VolleyBallMatch (String place, String date, String startHour, int numberOfTicket, double priceOfTickets) {
        super (place,date,startHour,numberOfTicket,priceOfTickets);
    }
   public String getFirstTeam(){  
       return this.firstTeam;
   }    
   public void setFirstTeam(String firstTeam){
       this.firstTeam = firstTeam;
   }
   
   public String getSecondTeam(){  
       return this.secondTeam;
   }
    public void setSecondTeam(String secondTeam){
       this.secondTeam = secondTeam;
   }
    
    
    @Override
    boolean sellTickets(int num) throws NoMoreTicketsException {
        if(numberOfTickets >= num){
            numberOfTickets += num;
            return true;
        }else throw new NoMoreTicketsException("There are no mo tickets !!! ");
       
    
    }
}
