package TypeInferenceGenerics;

public class TestGenerics4 {

    public static <E> void printArray(E [] el){
    	for(E element :el){
    		System.out.println(element);
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
		String [] strArray = {"1 dobre","2 sredno","3 super"}; 
        Integer [] intArray = {1,432,42,423,32};
		
        System.out.println("Printing string array!!!");
        printArray(strArray);
        System.out.println("Printing int array!!!");
        printArray(intArray);
        
	}

}
