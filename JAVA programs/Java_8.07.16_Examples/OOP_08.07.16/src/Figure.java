
class Figure {
	double dim1;
	double dim2;
	
   Figure(int a, int b){
	   dim1 = a;
	   dim2 = b;
   }
   Figure(int a){
	   dim1 = dim2 = a;
   }
   double area () {
	   System.out.println(" Area of Figure is undefined !!! ");
	   return 0;
   }
   
}

