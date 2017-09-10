
public class Test {

	public static void main(String[] args) {

		CreateArr ob = new CreateArr();

		for (int i = 0; i < ob.array.length; i++) {
			ob.array[i] = (int) (Math.random() * 100);
		}

		for (int i = 0; i < ob.array.length; i++) {
			System.out.print(" " + ob.array[i]);
		} 
		
		System.out.println(" After construction"); 
		PrintingThread obb1 = new PrintingThread(ob); 
		SortingThread obb2 = new SortingThread(ob); 
		obb1.start(); obb2.start();
	}
} class CreateArr {
	int[] array = new int[1000]; public CreateArr() {
		for (int i = this.array.length - 1; i >= 0; i--) {
			this.array[i] = i;

		}
	}

}