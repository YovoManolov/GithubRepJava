
public class VariableLengthArgs {

	public static void main(String[] args) {
		System.out.println(average(8,65,432,43));

	}
    ///    !!!!     "..."    !!!!!!    you dont know how many arguments you need !  
	public static int average(int ...numbers) { ///numbers is an ARRAY !!!!!
		int total = 0;
		for (int x : numbers) total += x;
		
			return total /numbers.length ;
	}
}
  