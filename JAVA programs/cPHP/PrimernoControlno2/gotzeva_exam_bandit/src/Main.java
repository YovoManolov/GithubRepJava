
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		Villain billy = new Villain(2,2,2,"Billy","","",
				"Billy", 10, 10000);
		Villain john = new Villain(2,2,2,"John Smit","","",
				"John", 5, 0);
		Villain.Skrmish(billy, john);
	}

}
