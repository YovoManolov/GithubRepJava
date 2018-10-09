
public class forEach {

	public static void main(String[] args) {
		int a[] = new int [4] ,i, sum = 0;
		
		for(i = 1 ; i<5  ;i++){
			a[i-1] = i;
		}
        
		for(int newArray : a) {
			sum += newArray ;
			if(newArray == 4) break;
		}
		
		System.out.println(" " + sum);
	}

}
