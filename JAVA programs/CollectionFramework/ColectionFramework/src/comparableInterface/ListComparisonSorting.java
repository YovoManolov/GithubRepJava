package comparableInterface;
import java.util.*;

class ListComparisonSorting {

	public static void main(String[] args) {
		LinkedList <Student> lls = new LinkedList <Student> ();
		
		Student st1 = new Student(1234435 ,"student1", 23);
		Student st2 = new Student(3534235 ,"student2", 21);
		Student st3 = new Student(4334235 ,"student3", 22);
				
		lls.add(st1);
		lls.add(st2);
		lls.add(st3);
		
		Collections.sort(lls);
		for(Student st : lls){
			System.out.println("Printing the Students based"
					+ " on that how old are they");	
           System.out.println("FaculityNumber :  " + st.faculityNumber + "Name :    " + st.name + "Age:    "  +st.age );
		}
		
	}

}
