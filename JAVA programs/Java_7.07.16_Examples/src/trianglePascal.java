
	
import java.util.Scanner;



public class trianglePascal {

	public static void main(String[] args) {
		
		System.out.println("Enter the number of rows:");
		Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		
		int[][] triangle=new int[n][];
		
		  for (int row=0; row<triangle.length; row++)
          {
                triangle[row]=new int[row+1];
          }
		  
		triangle[0][0]=1;
		
		//Entering the triangle
		for(int row=0; row<=triangle.length; row++){
			for(int col=0; col<=triangle[row].length; col++){
				triangle[row][col]=triangle[row-1][col-1]+triangle[row-1][col];
			}
		}
		
		//Printing the triangle
		for(int row=0; row<=triangle.length; row++){
			for(int col=0; col<=triangle[row].length; col++){
				System.out.println(triangle[row][col] + " ");
			}
		}


	}

}
