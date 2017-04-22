package threadEnumerateDemo;

class ThreadEnumerateDemo {

	public static void main(String[] args) {
	 // TODO Auto-generated method stub
       Thread t = Thread.currentThread();
       
       t.setName("Admin Thread");
       System.out.println("Thread = " + t);
       
       int count = Thread.activeCount();
       System.out.println("Currently active threads are : " + count);
       
       Thread th[] = new Thread[count];
       
       Thread.enumerate(th);
       
       for(int i = 0; i<count ;i ++ ){	   
    	   System.out.println(i + ": " + th[i]);
       }     
	}

}
