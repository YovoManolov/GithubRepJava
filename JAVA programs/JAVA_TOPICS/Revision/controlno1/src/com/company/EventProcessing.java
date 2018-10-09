package com.company;

import java.io.FileNotFoundException;

public class EventProcessing {
    public EventProcessing() throws FileNotFoundException {

    }
    public static void main(String[] args) {

    }

    public static Event processTickets() throws FileNotFoundException {
        TicketLoader tl = new TicketLoader();
        Event[] concerts = new Concert[tl.elementNumber()];
        Event[] matches = new VolleyBallMatch[tl.elementNumber()];

        try {
            int concertCounter = 0;
            int matchCounter = 0;
            for(Event e : tl.loadEvents()){
                if(e instanceof Concert){
                    concerts[concertCounter++] = e;
                }else if(e instanceof VolleyBallMatch){
                    matches[matchCounter++] = e;
                }
            }
        } catch (UnrecognisedRowException e) {
            e.printStackTrace();
        }
        return null;
    }


}
