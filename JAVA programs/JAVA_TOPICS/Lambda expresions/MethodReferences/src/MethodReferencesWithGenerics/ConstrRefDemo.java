package MethodReferencesWithGenerics;

class ConstrRefDemo {
	public static void main(String[] args) {
		MyFunc <String> myClassCons = MyClass <String> ::new;	
		
		MyClass <String> mc = myClassCons.func("Yovo");
		// Use the instance of MyClass just created.
		System.out.println("val in mc is " + mc.getVal( ));

	}

}
