
class superEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       B ob = new B (2, 2.5435434353544233);
       ob.show();
	}

}

class A {
	int i;
	
}

class B extends A {
	double i;
	
	B(int i, double y ){
		super.i = i;
	    this.i = y ;
	}
	void show(){
		System.out.println("I form superclass : " + super.i);
		System.out.println("I form subclass : " + i);
	}
	
}