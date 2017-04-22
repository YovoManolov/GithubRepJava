package mathEquations;

import java.util.InputMismatchException;

public class LinearEquation extends Equation {
	 LinearEquation() throws InputMismatchException{
		    super.coefficient = new double[2];
		    super.getCefficientsFromConsole();
		  }
	 
		  LinearEquation(double[] coefficients) throws InputMismatchException{
		    super(coefficients);
		    if(coefficients.length!=2) throw new InputMismatchException("Linear Equation has two coefficients");
		  }
		  LinearEquation(double a, double b){
		    super(a, b);
		  }
		  public double[] solve() throws SolutionException{
		    if(super.coefficient[0]==0){
		      if(super.coefficient[1]==0) throw new SolutionException("All x are solutions");
		      else throw new SolutionException();
		    }
		    return new double[]{super.coefficient[0]/super.coefficient[1]};
		  }
}
