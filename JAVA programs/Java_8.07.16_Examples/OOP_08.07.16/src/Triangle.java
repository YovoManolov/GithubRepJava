
class Triangle extends Figure {
	int c;
	double Area; 
     Triangle(int a, int b ,int c){
    	 super(a,b);
    	 this.c = c;
     }
     
     double area () { 
       double HalfSum = (double)((dim1 + dim2 +c)/2) ;  
       Area = Math.sqrt(HalfSum *(HalfSum - dim1)*(HalfSum - dim2)*(HalfSum - c));	 
  	   return Area;
     }
}
