package mathEquations;
import java.util.InputMismatchException;
import java.util.Scanner;

/*  ����������� ���������� ���� Equation, ������������� ��������� Solvable, �������������
 *  ��������� �� ���������� ���. �������� ����������� �� �� �������� ���� ���� ���������� v
 *  ����� �� ��� double. ����������, �� ���� ��������� ���� �� ��� ������ �� ���� ������� � 
 *  �������� ���� ��������� ��������� ��� ��� �������. ������ ����� solve �� ������ �� �����
	���� ���������� ��������. ������������ ����� �getUserCoefficientsFromConsole()�, � ����� ������ 
	� ������������� �� ������� � �� ����� ���� ������� �� ������� �������� 
	�� ������������. ���� ����� ���� �� ������
 *  InputMismatchException ��� ���������� �������� �� ����� ���������� �� � �������.*/

public abstract class Equation implements Solvable{
	 double[] coefficient ;
	 Equation(double...coefficient){
		 this.coefficient = coefficient;
	 }
	 
	void printSolution() throws SolutionException{
		 double[]solution = this.solve();
		 System.out.println("The solution is: ");
		 for(int i=0 ; i< solution.length ;i ++ ){
			 System.out.println("X" +i + " = " + solution[i]);
		 }
	 }
	void getCefficientsFromConsole()throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		for(int i =0 ;i<this.coefficient.length ;i++){
			System.out.println((char)('a'+ i) + " = " );
			coefficient[i] = sc.nextDouble();
		}
		sc.close();
	}
	public abstract double[] solve () throws SolutionException;
}
