/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yovo
 */
public class TicketLoader implements Importable{
    FileReader fr = null;
    Scanner br = null;
  
    public TicketLoader() {
      try {
            fr = new FileReader("dailytickets.txt");
            br = new Scanner(fr);
      }catch(FileNotFoundException e ){
          System.out.println(e.getMessage());
      }
    }
    @Override
     public Event[] importDataFromFile() throws IOException, UnrecognisedRowException {
            int numberOfRows = getNumberOfRows();
           
            Event[] eventObjects;
            VolleyBallMatch vbm = null ;
            Concert c ;
            
            eventObjects = new Event [numberOfRows];

            String [] events = new String [numberOfRows] ;
            String [] event = new String[10];
            int i = 0;
          while( i < numberOfRows){
             //every token string is an event .
             events[i] = br.nextLine();
             i++;
           }
          
          i = 0;
          while( i < numberOfRows){
                //every item in array array is field of some event
                for (String event1 : events) {
                    System.out.println(event1);
                }
                    
                   event = events[i].split("\\*");
                   System.out.println(event.length);
                   int typeOfEvent = Integer.valueOf(event[0]);
                   int eventCounter = 0 ;
                   if(typeOfEvent == 1) {
                            vbm.identification = 1;
                            ++eventCounter;
                            //1*John Smith*Arena Armeec*15.11.2015*20:00*20000*50*
                            int i1 =  Integer.valueOf(event[5]);
                            double d = Double.valueOf(event[6]);
                            c = new Concert(event[2],event[3],event[4],i1,d);

                            c.setStarName(event[1]);
                            //e = instance of class Event
                            eventObjects[eventCounter] = c; 

                   }else if(typeOfEvent == 2){
                            ++eventCounter;
                            vbm.identification = 2;
                         //  2*Levski*CSK*Arena Armeec*16.09.2015*22:00*2000*25*
                            int i1 =  Integer.valueOf(event[6]);
                            int i2 = Integer.valueOf(event[7]);
                             vbm = new VolleyBallMatch(event[3],event[4], event[5], i1, i2);
                             vbm.setFirstTeam(event[1]);
                             vbm.setSecondTeam(event[2]);                
                             eventObjects[eventCounter] = vbm; 

                   }else throw new UnrecognisedRowException("This event is not recognized");

          }     
       return eventObjects;
     }
     private int getNumberOfRows(){   
         int numberOfRows = 0;
    
               while(true){

                    String str = br.nextLine();

                    if(str == null){
                        break;
                    }else  numberOfRows++;
               }  
        return numberOfRows;
     }
      
   
}
