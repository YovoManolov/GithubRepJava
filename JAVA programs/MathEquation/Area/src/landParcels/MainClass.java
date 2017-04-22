package landParcels;

public class MainClass {

	public static void main(String[] args) {
		Area a = new Area();
		
		boolean returnedResult;
		
		a.setAmount(56.89);
		a.setPlantation("vegetables");
		a.setSize(999.99);
        
		try{
			returnedResult = a.checkAmount();
			if(returnedResult){
				System.out.println("Amount is correct ");
			}
			
		}catch(AreaException e){
			e.getMessage();
		}
		
		try{

			returnedResult = a.checkType();
			if(returnedResult){
				System.out.println("Type is correct ");
			}
			
			
		}catch(AreaException e){
			e.getMessage();
		}
		
		
	
		
		a.setAmount(-99);
		a.setPlantation("trsad");
		
		try{
			returnedResult =  a.checkAmount();
			if(returnedResult){
				System.out.println("Amount is correct ");
			}
		}catch(AreaException e){
			System.out.println(e.getMessage() );
		}
		
		
		try{

			returnedResult =  a.checkType();
			if(returnedResult){
				System.out.println("Type is correct ");
			}
		}catch(AreaException e){
			System.out.println(e.getMessage());
		}
		
	}

}
