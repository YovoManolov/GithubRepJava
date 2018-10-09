
public class VarLengthArgsOLD_SCHOOL {

	static void VaTest(int...v){
			System.out.print("Number of args: " + v.length);
			System.out.print(";Content:  " );
			for (int i : v) {
				System.out.print(i + " ," );
			}
			System.out.println();
	}
	
	public static void main(String[] args) {
		
		 VaTest(5,765,34,4,23);
		 VaTest(1,24,3);
		 VaTest();
	}

}
