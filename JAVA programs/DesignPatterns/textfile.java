Business Delegate Pattern 

Client - Presentation tier code may be JSP ,servlet or UI java code.

Business Delegate  - A single entry point class for client entities to 			provide access to Busness Service methods.
LookUp Service - Lookup service object is resposible to get relative 			business implementation and provide business object access			   to business delegate object.

Business Service - Business Service interace. Concrete classes 			implement this business serice to provide actial business 			implementation logic.


Step1 
	
	public interface BusinessService {
		public void doProcessing();
	}


Step2
	public class JMSService implements BusinessService {
		@Override 
		public void doProcessing(){
			System.out.println("Processing task by 
									invoking JMS Service");
		}
	}

	public class EJBService implements BusinessService {
		@Override 
		public void doProcessing(){
			System.out.println("Processing task by 
									invoking EJB Service");
		}
	}


Step3
	public class BusinessLookup {
		public BusinessService 
				getBusinessService(String serviceType){
			if(serviceType.equalsIgnoreCase("EJB")){
				return new  EJBService();
			}else{
				return new JMSService();
			}
		}
	}


Step5

public class Client {
	BusinessDelegate businessService;

	public Client(BusinessService businessService){
		this.businessService = businessService;
	}

	public doTask(){
		businessService.doTask();
	}
}



Step6	
public class BusinessServicePatternDemo{
	public static void main(String[] args) {

	BusinessDelegate businessDelegate = new BusinessDelegate()
	businessDelegate.setServiceType("JMS");

	Client client = new Client(businessDelegate);
	client.doTask();

		
	}

}

decouple presentation tier and business tier.

Composite Entity  - primary entity bean. It can be coarse grained or 
		can contain a coarse grained object to be used for
		persistence purpouse.

Coarse-Grained Object - This object is an object 


	


Lazy initialization 

public class Program {
	public static void main(String []args){
		Fruit.getFruitByTypeName(FruitType.banana);
		Fruit.showAll();
		Fruit.getFruitByTypeName(Fruit.apple);
		Fruit.showAll();
		Fruit.getFruitByTypeName(Fruit.banana);
		Fruit.showAll();
	}
}

enum FruitType {
	none,
	apple,
	banana,
}


class Fruit {
	private static Map <FruitType,Fruit> types = new HashMap<>();

	private Constructor to force the use of factory method;
	private Fruit(FruitType type){}
	public static Fruit getFruitByTypeName(FruitType type){

	}
}


Decorator Pattern 

public interface Shape {
	void draw();
}


public class Ractangle implements Shape {
	@Override 
	public void draw(){
		System.out.println("Shape :ractangle");
	}
}


public class Circle implements Shape {
	@Override 
	public void draw(){
		System.out.println("Shape :circle");
	}
}

ShapeDecoration.java 

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;
	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw(){
		decoratedShape.draw();
	}
}

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape){
		super(decoratedShape);
	}

	@Override
	public void draw(){
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape){
		System.out.println("Border Color: Red");
	}
}


public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRactangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("Ractangle of red border");
		redRactangle.draw();
	}
}



public abstract class Shape implements Clonable {
	private String id ;
	protected String type;

	abstract void draw();

	public Object clone(){
		Object clone = null;

		try{
			clone = super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

		return clone;

	}

}


public class ShapeCache {

	private static Hashtable<String,Shape> shapeMap = 
			new Hashtable<String,Shape>();
	public static Shape getShape(String shapeId){
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
}



public static void loadCache(){
	Circle circle = new Circle();
	circle.setId("1");
	shapeMap.put(circle.getId(),circle);

	Square square = new Square();
	square.setId("2");

	shapeMap.put(square.getId(), square);
	Rectangle rectangle = new Rectangle();
	rectangle.setId("3");
}



Composite pattern - treats group of objects in similar way
 as a single object

 composes objects in
 terms of tree structure to represent part as well as whole 
 hierachy. 



public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}


public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}


public abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape){
		this.decoratedShape = decoratedShape;
	}

	public void draw(){
		decoratedShape.draw();
	}
}


public class RedShapeDecorator extends ShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape){
		super(decoratedShape);
	}

	@Override
	public void draw(){
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape){
		System.out.println("Border color: red");
	}
}

Facade pattern hides the complexities of the system 
and provides an interface to the client using which the client can 
access the system.

This pattern involves single class which provides simplified methods
required by client and delegates calls to methods  of existing system
classes.


Flyweight pattern  - reduce number of objects created 
decrease memory footprint and increase perfomance . 
reuses already created objects by storing them and 
creates new object when no matching object is found.


Proxy pattern - represents the functionaliy of another class.
This type of design pattern comes under structural pattern.

In proxy pattern, we create object having original 
object to interface its functionality to outer world.


Chain of Responsibility 

creates chain of reciever objects for a request. 
This pattern decouples sender and reciever of a request based 
on type of request.












