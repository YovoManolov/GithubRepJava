
class Box {
	private double width;
	private double height;
	private double depth;

		Box (Box ob) {
		   width = ob.width;
		   height = ob.height;
		   depth = ob.depth ;
		}
		Box (double w,double h , double d) {
		   width = w;
		   height = h;
		   depth = d;
		}
		Box (double a) {
		   width = a;
		   height = a;
		   depth = a;
		}
		Box () {
		   System.out.println("No parameters were enetered");
		   width = -1;
		   height = -1;
		   depth = -1;
		}
		   
		double velume () {
		   return  width * height * depth;
		}
}
