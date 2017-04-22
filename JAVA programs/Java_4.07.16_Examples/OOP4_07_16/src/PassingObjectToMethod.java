
public class PassingObjectToMethod {

	public static void main(String[] args) {
		
	 Test1 ob1 = new Test1(15, 12);
	 
	 System.out.println("a =  " + ob1.a  + " b =  " + ob1.b);
	 
	 ob1.result(ob1);
	 System.out.println("a =  " + ob1.a + " b =  " + ob1.b);

	}

}


class Test1 {
	int a , b ;
	
	Test1(int i, int j){
		a = i;
		b = j;
	}
	
	void result(Test1 o) {
		o.a /= 2;
		o.b *= 2;	
	}
}