package GenericMethod;

class GenMethDemo {
	static<T extends Comparable<T>, V extends T> boolean isIn(T x ,V[]y){
		for(int i=0; i < y.length ; i++){
			if(x.equals(y[i])) return true ;
			break;
		}
		return false;	
	}
	
	public static void main(String[] args) {
		Integer nums[] = {12,3432,5,464,6,32};
		int a = 5;
		if(isIn(a,nums)) System.out.println("The number is part of the array");
		else{
			System.out.println(a + " is not part of the array");
		}
		
		a = 8 ;
		if(!isIn(a,nums)){
			System.out.println(a + " is not part of the array");
		}
		
		
		String strs[] = { "one", "two", "three",
				         "four", "five" };
		String b = "five";
		
		if(isIn(b,strs)) System.out.println("The string ||" + b + " || is part of the array");
		else System.out.println("The string ||" + b + " || is not part of the array");
		
        
	}

}
