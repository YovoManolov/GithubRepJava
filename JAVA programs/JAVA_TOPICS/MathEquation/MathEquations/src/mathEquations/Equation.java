package mathEquations;
import java.util.InputMismatchException;
import java.util.Scanner;

/*  Дефинирайте абстрактен клас Equation, имплементиращ интерфейс Solvable, представляващ
 *  уравнение от неизвестен тип. Неговите коефициенти ще се записват като член променлива v
 *  масив от тип double. Забележете, че едно уравнение може да има повече от едно решение – 
 *  например едно квадратно уравнение има две решения. Затова метод solve не трябва да връща
	една единствена стойност. Реализирайте метод “getUserCoefficientsFromConsole()”, в който масива 
	с коефициентите се обхожда и за всеки един елемент се прочита стойност 
	от клавиатурата. Този метод може да хвърли
 *  InputMismatchException ако въведената стойност за даден коефициент не е числова.*/

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
