package Ex9;

interface MyFunc <T>{
 boolean func (T v1 ,T v2);
}

class HighTemp{
	private int hTemp;
	
	HighTemp(int ht) {
		hTemp = ht;
	}
	
	boolean sameTemp (HighTemp ht2) {
		return hTemp == ht2.hTemp;
	}
	
	boolean lessThanTemp(HighTemp ht2){
		return hTemp < ht2.hTemp;
	}
	
}
