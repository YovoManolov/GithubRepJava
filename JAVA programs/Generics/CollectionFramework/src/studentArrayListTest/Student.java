package studentArrayListTest;

class Student {
    long fn;
    String name ;
    int age;
    
    Student (long fn , String n , int a) {
    	this.fn = fn;
    	name = n;
    	age = a;
    }
    
    void printSt(){
    	System.out.println("Student Age is:  " + age);
		System.out.println("Student faculty number is:  " + fn);
		System.out.println("Student Name is:  " + name);
    }
}
