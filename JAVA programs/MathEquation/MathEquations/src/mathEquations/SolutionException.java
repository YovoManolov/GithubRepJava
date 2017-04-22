package mathEquations;

@SuppressWarnings("serial")
public class SolutionException extends Exception {
	/* Дефинирайте изключение SolutionException като наследник
	 *  на Exception. Съобщението за грешка по подразбиране да е „няма решение“.
	 * */
	
	SolutionException(){
		super("There is no solution");
	}
	SolutionException(String msg){
		super(msg);
	}
	
}
