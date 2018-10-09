package mathEquations;

import java.util.InputMismatchException;

public class QuadraticEquation extends Equation{
	QuadraticEquation(){
	    super.coefficient = new double[3];
	    super.getCefficientsFromConsole();
	  }
	  QuadraticEquation(double[] coefficients) throws InputMismatchException{
	    super(coefficients);
	    if(coefficients.length!=3) throw new InputMismatchException("Quadratic Equation has three coefficients");
	  }
	  QuadraticEquation(double a, double b, double c){
	    super(a, b, c);
	  }
	  public double[] solve() throws SolutionException{
	    if(super.coefficient[0]==0){
	      LinearEquation le = new LinearEquation(super.coefficient[0], super.coefficient[1]);
	      return le.solve();
	    }
	    double discriminant = super.coefficient[1]*super.coefficient[1]-4*super.coefficient[0]*super.coefficient[2];
	    if(discriminant<0){
	      throw new SolutionException("No real solutions");
	    }
	    else{
	      double[] solution = new double[2];
	      solution[0] = (-super.coefficient[1]+Math.sqrt(discriminant))/(2*super.coefficient[0]);
	      solution[1] = (-super.coefficient[1]-Math.sqrt(discriminant))/(2*super.coefficient[0]);
	      return solution;
	    }
	  }
}
