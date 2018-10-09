package mathEquations;

import java.util.InputMismatchException;
//������������ ������� �� �������������� � �ria : size 
// type (nasajdeniq ) (��� �� � fruits or vegetables ne e izpylneno throws AreaException)
// amount (kolichestwo producti);
//amount >= 0 && amount < size*100;
// syzdawam Exception Area Exception {������ 2�� ������� ���� �� �� ��������� �� ������ }
//

public class MainClass {

	public static void main(String[] args) {
		 Equation eq1 = new LinearEquation(2.0,3.0);
		    try{
		      eq1.printSolution();
		    }
		    catch(SolutionException e){
		      System.out.println(e.getMessage());
		    }
		    Equation eq2;
		    try{
		      eq2 = new QuadraticEquation();
		      eq2.printSolution();
		    }
		    catch(SolutionException err){
		      System.out.println(err.getMessage());
		    }
		    catch(InputMismatchException err2){
		      System.out.println("You entered an invalid coefficient value");
		    }

   }
}