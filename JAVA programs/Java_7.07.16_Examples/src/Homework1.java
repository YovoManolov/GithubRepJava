import java.util.Scanner; 

public class Homework1 {

	public static void main(String[] args) {
        int i , j ;  
        int InitVar , rows;
       
        Scanner tempVar = new Scanner(System.in);
        System.out.println("Enter the rows ! " );
        rows = tempVar.nextInt();
        
        
		int numbers [][] = new int [rows][];
		for(i=0; i<rows;i++){
			    j = i+1;
				numbers[i] = new int [j];
		}
		
		
		numbers[0][0] = 1;
		
		for(i=1; i<rows;i++){
			
				for(j = 0 ; j < rows ; j++){  // numbers[i].length - брой редовe
					 
					if(j == 0){
						 InitVar = numbers[i-1][j] ;
						 numbers[i][j] = InitVar;
					  }
					
				  if(j > (i - 1)){
							 InitVar = numbers[i-1][j-1] ;
							 numbers[i][j] = InitVar;
						 }
					  
				   else{ 
						InitVar = numbers[i-1][j] + numbers[i-1][j-1];
						numbers[i][j] = InitVar;
					  }
				}
				
		}
		
		System.out.print("  " + numbers[0][0] );
		for(i=1; i<rows ;i++){
			for(j = 0 ;j<numbers[i].length ; j++){
			
				System.out.print("  " +numbers[i][j] );
			}
			System.out.println(" ");
		}
		
		 tempVar.close();
	}

}
