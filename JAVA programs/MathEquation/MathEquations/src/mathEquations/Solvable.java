package mathEquations;

public interface Solvable {
	 double[] solve() throws SolutionException;
	 void printSolution() throws SolutionException;
}
