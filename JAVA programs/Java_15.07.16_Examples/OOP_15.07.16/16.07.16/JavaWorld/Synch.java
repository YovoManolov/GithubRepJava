package JavaWorld;

class Synch {

	public static void main(String[] args) {
		Callme target = new Callme();
		Caller ob1 = new Caller (target, "Hello");
		Caller ob2 = new Caller (target, "Synchronized");
		Caller ob3 = new Caller (target, "World");
        
		try{
			ob1.t.join(); 
			ob2.t.join(); // when the first is ready the second will start :)
			ob3.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println("Ready");
	}
}

class Callme{
	 synchronized void call (String msg){
		System.out.print("[ "+ msg);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;  //string 
	Callme target;  // obekt ot klas Callme 
	Thread t;  // obekt Thread : t
	
	public Caller (Callme targ, String s) {
		target = targ;
		msg = s;
		t =  new Thread(this);
		t.start();
	}
	
	public void run(){
		target.call(msg);
	}
}