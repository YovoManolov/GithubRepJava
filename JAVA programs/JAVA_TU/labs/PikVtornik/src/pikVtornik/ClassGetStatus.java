package pikVtornik;

public class ClassGetStatus {
	 static String GetStatus(double i){
	    	double index = i ;
	    	if(index < 18.5){
	    		return "You have underweight bodymass!!!";

	    	}
	    	else if(index < 25 ){
	    		return  "You have normal bodymass!!!";
	    	}
	    	else if(index <30 ){
	    		return "You have overweight bodymass!!!";
	    	}else if(index >30 ){
	    		return "You have obese bodymass!!!";
	    	}
	    	else return "The index was not right calculated";
	    	
		}
}
