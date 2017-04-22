package studentArrayListTest;
import java.util.*;
class StudentArrayListTest {

	public static void main(String[] args) {
		
		Student first  = new Student(123123,"Mitko0",19);
		Student second  = new Student(123129896,"Mitko1",21);
		Student third  = new Student(1276576,"Mitko2",22);
		
		ArrayList <Student> sal = new ArrayList <Student> ();
		
		sal.add(first);
		sal.add(second);
		sal.add(third);
		
		Iterator <Student> it = sal.iterator();
		
		System.out.println("printet with itterator \n\n");
		while(it.hasNext()){
		 	it.next().printSt();
 	
		}
		
		
		System.out.println("\n\n");
		System.out.println("Printed with for-each\n\n");
		for(Student obj : sal){
			obj.printSt();
		}
		
	}

}
