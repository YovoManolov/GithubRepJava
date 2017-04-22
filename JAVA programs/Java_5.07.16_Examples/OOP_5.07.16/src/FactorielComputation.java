
class FactorielComputation {

	public static void main(String[] args) {
		Factoriel f = new Factoriel ();
		
		System.out.println ("Factoriel of 3 is   : " + f.fact(3));
		System.out.println ("Factoriel of 4 is   : " + f.fact(4));
		System.out.println ("Factoriel of 5 is   : " + f.fact(5));
		

	}

}

class Factoriel{
	int fact(int i){
		int result ;
		if(i <= 1)	return 1;
		result = fact(i-1) * i;
		return result ;
	}	
}