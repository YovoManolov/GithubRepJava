
public class StackArray {

	public static void main(String[] args) {
		//last in furst out !!!!!!!!
		
		Stack myStack = new Stack (20);
		Stack myStack2 = new Stack (20);
		
		for(int i = 0 ; i<20;i++ ) myStack.push(i);
		for(int i = 10 ; i<30;i++ ) myStack2.push(i);
		
		System.out.println("Stack in myStack1: ");
			for(int i=0 ; i<20 ;i ++){
				System.out.println(myStack.pop());
			}
		System.out.println("Stack in myStack2: ");
			for(int i=0 ;i<20 ;i++){
				System.out.println(myStack2.pop());
			}

	}

}


class Stack {
	private int Stck [] ; // the name of the array can't be the same 
	                              //as the name of the class
	private int tos ; // top of the stack ;
	
	//pop "take out of the stack  " , push "add new  in the stack ", 
	
	// We must use method , because "tos" object is PRIVATE 
	Stack(int size) {
		Stck = new int [size];
		tos = -1;
	}
	
	int pop(){ 
		if(tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			return Stck[tos--]; 
		}
	}
	
	//push "add new  in the stack ", 
	void push (int a){
		if(tos == 19){
			System.out.println("Stack is full ");
		}
		else{	
		   a*=a;	
		   Stck[++tos] = a;
		}
	}
	
}