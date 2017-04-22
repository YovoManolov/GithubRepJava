package MethodReferencesWithGenerics;

//this class plays the role of initialization 
class MyClass<T> {
  private T val;
  
  MyClass(T v) {
	  val = v;
  }
  
  T getVal() {
	  return val;
  }
}
