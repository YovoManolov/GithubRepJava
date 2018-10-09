package pikPonedelnik1;

import java.util.Scanner;

public class Class {

	public static void main(String[] args) {
		//ime grupa universitet
       Scanner sc = new Scanner(System.in);		
	   int group  ;
	   String name , university;
	   

	   
	   System.out.println("Enter group");
	   group = sc.nextInt(); sc.nextLine();
	   System.out.println("Enter university");
	   university = sc.nextLine(); sc.nextLine();
	   System.out.println("Enter name ");
	   name =  sc.nextLine();
	   
	   System.out.println("The group : " + group);
	   System.out.println("The name : " + name);
	   System.out.println("The University : " + university);


  }
}