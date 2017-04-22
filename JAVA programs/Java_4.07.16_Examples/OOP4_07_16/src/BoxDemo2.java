class BoxDemo2 {
    public static void main(String[] args) {
		
		Box myBox = new Box (100, 70, 14) , myBox2 = new Box( 5) , myBox3 = new Box() ;
		Box myCloneBox = new Box(myBox);
		
		System.out.println("The velume is : " + myBox.velume());
		System.out.println("The velume 2 is : " + myBox2.velume());
		System.out.println("The velume 3 is : " + myBox3.velume());
		System.out.println("The velume 4 is : " + myCloneBox.velume());
			
	}

}


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


