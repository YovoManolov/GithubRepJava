package generics2;

class SimpGen {
	public static void main(String[] args) {
		
		TwoGen <Integer ,String >  tgOB;		
		 tgOB = new TwoGen <Integer ,String > (88, "MAGI");
		 
		 tgOB.showTypes();
		 
		 int v = tgOB.getob1();
		 System.out.println("The value of ob1 = " + v);
		 
		 String s = tgOB.ob2.toLowerCase();
		 System.out.println("The value of ob2 = " + s);
		 
	}

}
