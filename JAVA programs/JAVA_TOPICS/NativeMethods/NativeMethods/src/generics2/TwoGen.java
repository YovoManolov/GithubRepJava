package generics2;

class TwoGen <T,V>{
   T ob1;
   V ob2;
   
   TwoGen(T o ,V o1) {
	   ob1 = o;
	   ob2 = o1;
   }
   
   void showTypes(){
	   System.out.println("Type of T is " + ob1.getClass().getName());
	   System.out.println("Type of V is " + ob2.getClass().getName());
   }
   
   T getob1(){
	   return ob1;
   }
   
   V getob2(){
	   return ob2;
   }
}
