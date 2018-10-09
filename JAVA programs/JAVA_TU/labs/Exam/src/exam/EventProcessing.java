/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.IOException;


/**
 * Създайте клас EventProcessing, в койтo трябва да има два
 * публични масива- единият от концерти, а другият от волейболни мачове.
 * Имплементирайте статичен метод void processTickets(), в който 
 * използвайте TicketLoader-а, за да заредите дневните билети. 
 * С върнатия масив от Event обекти процедирайте по следния начин:
 * разделете обектите от тип Concert и от тип 
 * VolleyBallMatch и с тях напълнете статичните масиви. 
 * Може да използвате за целта instance of. Статичните масиви ще
 * се взимат от друг компонент на уеб приложението */

public class EventProcessing {
   
   public static Concert[] arrayOfConcerts = null;
   public static VolleyBallMatch[] arrayOfVolleyball = null;
   private final static int SIZE_OF_OBJECT_BUFFER = 100;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		System.out.println("Only for testing:");
		try {
		     processTickets();
		} catch (IOException | UnrecognisedRowException e1) {
                   e1.getMessage();
		}
		Concert c = arrayOfConcerts[0];
		try {
			c.sellTickets(500);
			c.sellTickets(20000);
		} catch (NoMoreTicketsException e) {
			System.out.println(e.getMessage());
		}

	}
        
        
        public static void processTickets() throws IOException, UnrecognisedRowException {
		System.out.println("Processing...");
		arrayOfConcerts = new Concert[SIZE_OF_OBJECT_BUFFER];
		arrayOfVolleyball = new VolleyBallMatch[SIZE_OF_OBJECT_BUFFER];
		TicketLoader t = new TicketLoader();
            
                Event [] arrayOfEvents;
               arrayOfEvents = (Event []) t.importDataFromFile();
                
		int i = 0;
		int j = 0;
		for (Event e : arrayOfEvents) {
			if (e instanceof Concert) {
				arrayOfConcerts[i++] = (Concert) e;
			} else if (e instanceof VolleyBallMatch) {
				arrayOfVolleyball[j++] = (VolleyBallMatch) e;
			}
		}
		System.out.println("Process of importing finished.");
		System.out.println("Num loaded concerts: " + i);
		System.out.println("Num loaded volleyballs: " + j);
	}

  }

 
