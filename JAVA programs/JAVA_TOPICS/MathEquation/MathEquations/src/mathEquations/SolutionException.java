package mathEquations;

@SuppressWarnings("serial")
public class SolutionException extends Exception {
	/* ����������� ���������� SolutionException ���� ���������
	 *  �� Exception. ����������� �� ������ �� ������������ �� � ����� �������.
	 * */
	
	SolutionException(){
		super("There is no solution");
	}
	SolutionException(String msg){
		super(msg);
	}
	
}
