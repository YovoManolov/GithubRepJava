package ComparatatorExample;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		LinkedList <Student> ll =  new LinkedList <Student> ();
		
		ll.add(new Student(1234435 ,"student", 23));
		ll.add(new Student(1234435 ,"atudent2", 22));
		ll.add(new Student(1234435 ,"btudent3", 21));
		
		System.out.println("Comparison by name");
		
		Collections.sort(ll,new NameComparator());
		for(Student st : ll){
	         System.out.println("FaculityNumber :  " + st.faculityNumber 
	        		          + "Name :    " + st.name + "Age:    "  +st.age );
		}
		
		
        System.out.println("Comparison by Age");
		
		Collections.sort(ll,new AgeComparator());
		for(Student st1 : ll){
	         System.out.println("FaculityNumber :  " + st1.faculityNumber 
	        		          + "Name :    " + st1.name + "Age:    "  +st1.age );
		}
		

	}

}
