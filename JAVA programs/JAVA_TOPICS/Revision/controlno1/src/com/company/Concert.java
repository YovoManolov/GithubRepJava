package com.company;

public class Concert extends Event {

    protected String starName ;

    public Concert(String place, String date, String startHour,
                   int numberOfTickets, float priceOfTickets, String starName) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.starName = starName;
    }

    @Override
    public boolean sellTickets(int num) throws NoMoreTicketException {
        if(numberOfTickets<num) {
            throw new NoMoreTicketException();
        }else{
            numberOfTickets -= num;
            return true;
        }
    }
}
