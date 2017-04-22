package generics;

class Gen<T> {
   T ob;
    Gen(T o) {
    	ob = o;
    }
    
    T getob(){
    	return ob;
    }
    void  showType(){
    	System.out.println("The name of T is : " + ob.getClass().getName());
    }
}
