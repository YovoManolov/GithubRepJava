package ConstrRefDemo3;

class ConstrRefDemo3 {
    
	// A factory method for class objects. The class must
	// have a constructor that takes one parameter of type T.
	// R specifies the type of object being created.
	static <R,T> R myClassFactory(MyFunc<R, T> cons, T v ) {
		return cons.func(v);  //cons = instance of the class being created
	}
	static <R> R myClassFactory(MyFuncNoParam <R> cons) {
		return cons.func();  //cons = instance of the class being created
	}
	public static void main(String args[]){
		
		MyFuncNoParam<MyClass<Float>> myClassCons1 = MyClass<Float> :: new;
		//MyClass is GENERIC METHOD
		
		// Create an instance of MyClass( mc ) by use of the factory method.
		MyClass <Float> mc4 = myClassFactory(myClassCons1);
		
		// Use the instance of MyClass just created.
		System.out.println("val in mc4 (Float) is " + mc4.getVal( ));
		
		// Create a reference to a MyClass constructor.
		// In this case, new refers to the constructor that
		// takes an argument.
			
		//static <R,T> R myClassFactory(MyFunc<R, T> cons, T v) 
		// R specifies the type of the object being created
		
		MyFunc<MyClass<Double> , Double> myClassCons = MyClass<Double> :: new; 
		//MyClass is GENERIC METHOD
		
		// Create an instance of MyClass( mc ) by use of the factory method.
		MyClass <Double> mc = myClassFactory(myClassCons, 231.4234);
		System.out.println("val in mc is " + mc.getVal( ));
		//Now, create a different class by use of myClassFactory().
		MyFuncNoParam<MyClass2/*NOT GENERIC*//*parameter of type T*/> myClassCons2 = MyClass2::new;
		//Create an instance of MyClass2 (myClassCons2) by use of the factory method.
		MyClass2 mc2 = myClassFactory(myClassCons2);
		
		// Use the instance of MyClass just created.
		System.out.println("Str in mc2 is " + mc2.getVal());
    }
}	
