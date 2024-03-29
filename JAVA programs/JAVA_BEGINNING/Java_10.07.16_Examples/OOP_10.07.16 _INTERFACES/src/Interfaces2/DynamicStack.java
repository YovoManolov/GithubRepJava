package Interfaces2;

public class DynamicStack implements IntStack{
	private int Stack[];
	private int tos;
	
	//allocate and inicialize stack
	public DynamicStack (int size){
		Stack = new int [size];
		tos = - 1 ;
	}
		//Push an item onto the stack
		public void push (int item){
		   if(tos == Stack.length-1){
			   System.out.println("Stack is full !");
			   System.out.println("Stack will be now 2x larger !");
			   int temp[] , i;
			   temp = new int [Stack.length * 2];
			   for(i=0 ; i<Stack.length ; i++) temp[i] = Stack[i];
			   Stack = temp;		   
			   Stack[++ tos] = item;
		   }
		   else {
			  Stack[++ tos] = item;
		   }
		}
	    public int pop(){
	    	if(tos < 0){
	    		System.out.println("Stack underflow !");
	    		return 0;
	    	}
	    	else return Stack[tos--] ;
	    }	  
}