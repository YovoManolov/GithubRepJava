package pikVtornik;
import java.util.Scanner;
public class BMICalc {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintingIntroduction pi = new PrintingIntroduction();
	    pi.printIntroduction();		
		
		for(;;){
			int SerialNumber = 0;
			SerialNumber ++;
			double index = BmiFor.bmiFor();
			String Results;
			Results = ResultReporting.ReportResults(SerialNumber, index, ClassGetStatus.GetStatus(index));
			System.out.println(Results);
			System.out.println("Is it there another waiting person ? ");
			String st = sc.next();
			if(st.compareTo("yes") == 0){
			  continue;
			}else break;
		}
		sc.close();
		
	}
}
