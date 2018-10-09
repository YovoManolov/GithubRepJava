package toStringDemo;

class Box {
 double  width;
 double  height;
 double  depth;
   Box(double w ,double h,double d){
	   width = w;
	   height = h;
	   depth = d;
   }
   
   public String toString() {
	   //Automatic use of toString method
	   // for width , height and depth
	   return "Dimensions are " + width + " by " 
			   + height + " by " + depth + " .";
   }
}