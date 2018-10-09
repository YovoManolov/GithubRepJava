package Interfaces2;

public class TestInterfaces implements MyInterface {
	int p ; 
	
	public void callback(int p){
		System.out.println("callback called with " + p);
	}
}
