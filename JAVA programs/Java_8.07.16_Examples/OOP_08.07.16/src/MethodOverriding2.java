
class MethodOverriding2 {

	public static void main(String[] args) {
	   Figure f = new Figure(3,45);
	   Rectangle r = new Rectangle (5);
	   Triangle t = new  Triangle (3,5,7);
       
	   System.out.println("Area of Figure is : " + f.area());
	   System.out.println("Area of Rectangle is : " + r.area());
	   System.out.println("Area of Triangle  is : " + t.area());
	
	}

}

