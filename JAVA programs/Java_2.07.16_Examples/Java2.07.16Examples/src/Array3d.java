
public class Array3d {

	public static void main(String[] args) {
	   int ThreeD_Array [][][] = new int [5][2][6];
	   
	   int i , j , k;
	   
	   for(i=0; i< 5;i++){
		   for(j = 0; j<2 ; j++){
			   for(k = 0;k < 6; k++){
				   	ThreeD_Array [i][j][k] = i * j * k;	
			   }
		   }
	   }
	   
	   for(i=0; i< 5;i++){
		   for(j = 0; j < 2 ; j++){
			   for(k = 0;k < 6; k++){
				   System.out.print("  " + ThreeD_Array [i][j][k] );	
			   }
			   System.out.println(); 
		   }
		   System.out.println() ;
	   }
	   
	}

}
