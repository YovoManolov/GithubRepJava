
public class SuperEx {

	public static void main(String[] args) {
		
			BoxWeight mybox1 = new BoxWeight(10, 20, 15, 34.3);
			BoxWeight mybox2 = new BoxWeight(2, 3, 4, 0.076);
			BoxWeight mybox3 = new BoxWeight(); // default
			BoxWeight mycube = new BoxWeight(3, 2);
			BoxWeight myclone = new BoxWeight(mybox1);
			
			double vol1;
			vol1 = mybox1.velume();
			System.out.println("Volume of mybox1 is " + vol1);
			
			vol1 = mybox2.velume();
			System.out.println("Volume of mybox2 is " + vol1);
			
			vol1 = mybox3.velume();
			System.out.println("Volume of mybox3 is " + vol1);
			
			vol1 = mycube.velume();
			System.out.println("Volume of mycube is " + vol1);
			
			vol1 = myclone.velume();
			System.out.println("Volume of myclone is " + vol1);
			
	}

}

class Box {
	private double width, height, depth;
	Box (double w,double h,double d){
		width = w;
		height = h;
		depth = d;
	}
	Box (Box ob){
		width = ob.width;
		height = ob.height;
		depth = ob.depth;
	}
	Box (double l){
		width = height = depth = l;
	}
	Box (){
		width = height = depth = -1;
	}
	
	double velume (){
		return width * height * depth;
	}
}
		
class BoxWeight extends Box{
		double weight;
		BoxWeight(double w,double h,double d,double wght){
			super(w,h,d);
			weight = wght;
		}
	    BoxWeight(double l,double wght){
			super(l);
			weight = wght;
		}
	    BoxWeight(){
			super();
			weight = -1;
		}
	    BoxWeight (BoxWeight ob){
	    	super(ob);
	    	weight = ob.weight;
		}
	}    
