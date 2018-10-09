package example2;

class LambdaDemo2 {

	public static void main(String[] args) {
		
		NumericTest isEven = (n) -> (n % 2) == 0; // test returns boolean value 
        if (isEven.test(10)) System.out.println("10 is even");
        if (isEven.test(8)) System.out.println("8 is even");
        
        
        NumericTest equal10 = (n)-> n+ 5 == 5;
        
        if(equal10.test(5)) System.out.println("Yes it is now equal 10");
        if(equal10.test(0)) System.out.println("No it is not equal 10 now");

	}

}
