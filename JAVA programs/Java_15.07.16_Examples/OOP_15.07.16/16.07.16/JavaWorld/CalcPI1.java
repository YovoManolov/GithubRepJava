package JavaWorld;

class MyThread1 extends Thread
{
	boolean negative = true;
    double pi; // default value =  0.00
    
	    public void run (){
	     	
		    for(int i = 3 ; i<100000 ; i += 2){
		    	if(negative){
		    		pi-= (1.0 /i);
		    	}else{
		    		pi +=  (1.0 /i);
		    	}
		    	negative = !negative;
		    }
		    
		    pi += 1.0;
		    pi*=4.0;
		    System.out.println("Finishing calculating PI !!!!! ");
       }
 } 

class CalcPI1 {

	public static void main(String[] args) {
		MyThread1 mt = new MyThread1();
		 
		mt.start();
			while(mt.isAlive()){
				try{
				     Thread.sleep(10);
				}catch(InterruptedException e){
					
				}
			}	
			
			System.out.println("Pi = " + mt.pi);
	}
}


