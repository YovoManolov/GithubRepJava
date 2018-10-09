package GenInterfaces;

public class GenIFDemo {

	public static void main(String[] args) {
		Integer inums [] = {5,6,9,8,2,6};
		Character chs[] = {'b','r','g','z'};
		
		MyClass <Integer> iob = new MyClass<Integer>(inums);
		MyClass <Character> cob =  new MyClass<Character>(chs);
		
		System.out.println("Max value in inums " + iob.max());		
		System.out.println("Min value in inums " + iob.min());
 		
		System.out.println("Max value in chs " + cob.max());		
		System.out.println("Min value in chs " + cob.min());
	}

}
class MyClass<T extends Comparable<T>> {
	T vals[];
	
	MyClass(T[] o){
		vals = o;
	}
	
	public T min(){
		T v = vals[0];
		
		for(int i = 1;i<vals.length ;i ++ ){
			
			if(v.compareTo(vals[i]) > 0){    
				v = vals[i];          
		    }
		}
		return v ;
	}
	
	public T max(){
		T v = vals[0]; 
	
		for(int i = 1; i<vals.length; i++) {
			if(v.compareTo(vals[i]) < 0 ) v = vals[i];
		}
	 return v;
	}
	
}