
class finalizeMethod {

	public static void main (String[] args) {
		while(true){
			new Box() ;
		}
	}
}

class Box {
	Box(){
		super();
		System.out.println("This object reference is  located on the heap at : " + this);
	}
	
	protected void finalize (){
		System.out.println("!!!FINALIZED !!! " + this);
	}
}
