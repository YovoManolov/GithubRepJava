package JavaWorld;

class PC2 {

	public static void main(String[] args) {
		
		Q q = new Q();
		
		new Producer(q);
        new Consumer(q);
     
	}

}

class Q {
	int n;
	public void get(){
		System.out.println("The number n is : " + n);
	}
	public int put(int n){
		this.n = n;
		System.out.println("Produced number is : " + n);
		return n;
	}
	
}

class Producer{
	Q q;
	
	Producer (Q q) {
		this.q = q;
		new Thread((Runnable) this, "Producer").start();
	}
	public void run(){
		int i = 0 ;
		
		while (true){
			i++;
			q.put(i);
		}
	}
	
}

class Consumer{
	Q q;
	
	Consumer(Q q){
		this.q = q;
		new Thread((Runnable) this, "Consumer").start();
	}
	public void run(){
		while(true){
		  q.get();
		}
	}
	
}