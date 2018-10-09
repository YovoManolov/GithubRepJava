
class Rectangle extends Figure {
	double Area; 
	Rectangle(int a ){
   	 super(a);
    }
	
	 double area () {
		   Area = dim1 * dim2;
		   return Area;
	   }
}
