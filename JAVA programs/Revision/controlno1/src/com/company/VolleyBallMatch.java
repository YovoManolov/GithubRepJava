package com.company;

public class VolleyBallMatch extends Event{

    protected String firstTeam ;
    protected String secondTeam ;

    public VolleyBallMatch(String place, String date, String startHour,
                           int numberOfTickets, float priceOfTickets, String firstTeam , String secondTeam) {
        super(place, date, startHour, numberOfTickets, priceOfTickets);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    @Override
    public boolean sellTickets(int num) throws NoMoreTicketException {
        return false;
    }
}
