package stringSroting;

class StringSrotingDemo {
	static String arr[] = {
		"Now", "is", "the", "time", "for", "all", "good", "men",
		"to", "come", "to", "the", "aid", "of", "their", "country"
		};
	public static void main(String[] args) {
		int count = 1;
		for(int i = 0 ; i < arr.length; i ++ ,count ++){
			for(int j = i+1 ; j < arr.length ;j++){
				if(arr[i].compareToIgnoreCase(arr[j]) > 0) {
					String t = arr[i];
					arr[i]= arr [j] ;
					arr[j] = t ;
				}
			}
			if((count = count % 5) == 0){
				count = 1;
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		
	}

}
