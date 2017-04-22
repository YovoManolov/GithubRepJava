package RunTimeTypeComparisonsGenerics;

class HierDemo3 {
	public static void main(String[] args) {
		Gen<Integer> iOb = new Gen<Integer>(88);
		Gen2<Integer> iOb2 = new Gen2<Integer>(99);
		
        Gen2<String> sOb2 = new Gen2<String>("Magi");
        
        if(iOb instanceof Gen<?>){
        	System.out.println("iOb instance of Gen");
        }
        if(iOb2 instanceof Gen<?>){
        	System.out.println("iOb2 instance of Gen");
        }
        if(iOb instanceof Gen2<?>){ ///Wrong
        	System.out.println("iOb instance of Gen2");
        }
        if(iOb2 instanceof Gen2<?>){
        	System.out.println("sOb2 instance of Gen2");
        }
        if(sOb2 instanceof Gen2<?>){
        	System.out.println("sOb2 instance of Gen2");
        }
        
        if(sOb2 instanceof Gen<?>){
        	System.out.println("sOb2 instance of Gen");
        }
        
        
	}

}
