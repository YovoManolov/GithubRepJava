package generics3;

class AverageNumbGen <T extends Number>{
	T[] array ;
	 
	
	AverageNumbGen(T[] o){
		array  = o ;
	}
	double average (){
		double sum = 0.0;
		for(int i = 0 ; i < array.length ; i++){
			sum += array[i].doubleValue();
		}
		
		return (double)sum /array.length;
	}
	
}
