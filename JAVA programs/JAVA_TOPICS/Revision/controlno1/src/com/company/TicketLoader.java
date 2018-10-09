package com.company;

import java.io.*;

public class TicketLoader {
    private final File f = new File("dailytickets.txt");
    private final FileReader fr = new FileReader(f);
    private  BufferedReader bfr = new BufferedReader(fr);

    public TicketLoader() throws FileNotFoundException {
    }

    public int elementNumber(){
        int lineCounter = 0;
        try {
            while((bfr.readLine()) != null &&
                    (bfr.readLine()).length() != 0){
                lineCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCounter;
    }

    public Event[] loadEvents() throws UnrecognisedRowException {

        Event[] events = new Event[this.elementNumber()];

        try {
                String singleEvent ;
                int i = 0;
               while((singleEvent = bfr.readLine()) != null &&
                        singleEvent.length() != 0 &&
                       this.elementNumber() > i){
                   String[] singleEventInfo = singleEvent.split("[*]");

                   if ( Integer.parseInt(singleEventInfo[0]) == 1){
                       Event concert = new Concert(
                               singleEventInfo[2],
                               singleEventInfo[3],
                               singleEventInfo[4],
                               Integer.parseInt(singleEventInfo[5]),
                               Float.valueOf(singleEventInfo[6]),
                               singleEventInfo[1]);
                       events[i++] = concert;
                   }else if(Integer.parseInt(singleEventInfo[0]) == 2) {
                       Event match = new VolleyBallMatch(
                               singleEventInfo[3],
                               singleEventInfo[4],
                               singleEventInfo[5],
                               Integer.parseInt(singleEventInfo[6]),
                               Float.valueOf(singleEventInfo[7]),
                               singleEventInfo[1],
                               singleEventInfo[2]);

                       events[i++] = match;
                   }else {
                       throw new UnrecognisedRowException();
                   }

                }

            }catch (IOException e) {
                e.printStackTrace();
            }

        return events;
        }

}
