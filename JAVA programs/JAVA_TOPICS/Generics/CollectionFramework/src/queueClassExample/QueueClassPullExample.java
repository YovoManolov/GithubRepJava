package queueClassExample;
import java.util.*;
class QueueClassPullExample {

	public static void main(String[] args) {
	      PriorityQueue <Integer> pq = new PriorityQueue <Integer> ();
	      
	      pq.add(1);
	      pq.add(2);
	      pq.add(3);
	      pq.add(4);

	     //  add offer remove poll element peek
	      
          Iterator <Integer> it = pq.iterator();
          
          System.out.println("Printing trough itterator");
          while (it.hasNext()){
        	  System.out.println(it.next());
          }
          
          System.out.println("Using peek to check the first"
          	            	+ " el , then printing it ");
          
          int h = pq.peek();
          
          System.out.println("Trough peek() : " + h);
          
          System.out.println("Priority queue after peek"); 
          for(Integer io : pq){
        	  System.out.println(io);
          }
          
          h = pq.poll();
          System.out.println("printing the ellement took from pool(): " + h);
          
          System.out.println("Priority queue after poll"); 
          Iterator <Integer> it1 = pq.iterator();
          while(it1.hasNext()){
        	  System.out.println(it1.next());
          }
          
          pq.removeAll(pq);
          try{
        	  System.out.println("Trying to take non-existing element trough element() \n");
        	  pq.element();
          }catch(NoSuchElementException e){
        	  System.out.println("No Such Element Exception was thrown \n");
          }
        
          /*element ()  and peek () are almost the same the diference 
           * between the two of them is that element throws noSuchElementException 
           * when the queue is empty !!!!! */
          
          
          
	 }      
}
