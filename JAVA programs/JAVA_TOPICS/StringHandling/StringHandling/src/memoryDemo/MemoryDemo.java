package memoryDemo;
class MemoryDemo {
   public static void main (String [] args) {
	   
	   //getRuntime > returns the current RUNTIME OBJECT. 
       Runtime r = Runtime.getRuntime();
	   long mem1 ,mem2;
	   mem1 = r.freeMemory();
	   System.out.println("Free mem before allocation of 1000  Int obj's : " + mem1);
	   
	   
	   System.out.println("This is the total memory : " + r.totalMemory()); 
	   // total memory  
	   Integer  someints []  = new Integer[100];
	  
	   
	   //freeMemory Returns the approximate number of 
	   // bytes available in Java  runtime system 
	   mem1 = r.freeMemory(); 
	   System.out.println("Initial free memory: " + mem1);
	   
	   r.gc();
	   
	   mem1 = r.freeMemory();
	   System.out.println("Free memory afrer garbage collection "  + mem1);
	   
	   for(int  i= 0 ; i < 100 ; i ++ ){
		   someints[i] = new Integer (i); //allocating Integers
		   
	   }
	   for(int  i= 0 ; i < 100 ; i ++ ){
		  System.out.print(someints[i] + " ,");
		  if(i%10 == 0) {
			  System.out.println();
		  }
		   
	   }
	   
	   System.out.println();
	   mem2 = r.freeMemory();
	   System.out.println("Free memory afrer allocation "  + mem2);
	   System.out.println("Memmory used by allocation " + (mem1 - mem2));
	   
	   //discard Integers
	   
	   for(int i = 0 ; i < 100; i++ ) {
		   someints [i] = null;
	   }
	   
	  r.gc() ; // r - Runntime  object 
	  mem2= r.freeMemory();
	  System.out.println("Free Memory after collecting discard Integers " + mem2);
   }
}