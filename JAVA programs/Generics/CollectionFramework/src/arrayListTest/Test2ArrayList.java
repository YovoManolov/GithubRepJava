package arrayListTest;

import java.util.*;
class Test2ArrayList {

	public static void main(String[] args) {
	    ArrayList <Double> dl = new ArrayList<Double> () ;
	    
	    Random d = new Random();
	    
	    
	    dl.add(d.nextDouble() + d.nextInt());
	    dl.add(d.nextDouble() + d.nextInt());
	    dl.add(d.nextDouble() + d.nextInt());
	    dl.add(d.nextDouble() + d.nextInt());
	    dl.add(d.nextDouble() + d.nextInt());
	    dl.add(d.nextDouble() + d.nextInt());
  
	    
	    Iterator it = dl.iterator();
	    
	    while(it.hasNext()){
	    	int i= 0;  i++;
	    	System.out.println("Double number  " + i + " \n " + it.next());
	    }
	    
	    for(Double dbl :dl){
	    	int i= 0;  i++;
	    	System.out.println("Double number  " + i + " \n " + dbl);
	    }
	}

}
