package pikVtornik;

public class ResultReporting {
	double index;
	int SerialNumber;
	String status ;
	ResultReporting(int SerialNumber, double index ,String status ){
		this.index = index;
		this.SerialNumber = SerialNumber;	
		this.status = status;
	}
	static String ReportResults (int SerialNumber, double index ,String status){
		// човекът с номер Х има BMI= х.х 
		return "Person with number " + SerialNumber + 
			    " have BMI =  " +   index + " = > " + status;  
	    
	}
}
