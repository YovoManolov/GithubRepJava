package GenSuperclass;

class Gen2 <T,V> extends Gen<T> {
  V ob2;
  
  Gen2(T ob ,V pob){
	  super(ob);
	  ob2 = pob; 
  }
  
  V getob2(){
	  return ob2;
  }
}
