
public class BoxDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shipment myShipment = new Shipment (10.5435, 70.2342, 14.32423 , 213.4324, 24325.5345);
		Shipment myShipment2 = new Shipment(5.3242 ,62.324,100.5435);
	    Shipment myShipment3 = new Shipment();
		Shipment myCloneShipment = new Shipment(myShipment2);
		
		System.out.println("The velume is : " + myShipment.velume());
		System.out.println("The cost of the Shipment  is : " + myShipment.cost);
		System.out.println("The velume2 is : " + myShipment2.velume());
		System.out.println("The cost of the Shipment2  is : " + myShipment2.cost);
		System.out.println("The velume3 is : " + myShipment3.velume());
		System.out.println("The cost of the Shipment3  is : " + myShipment3.cost);
		System.out.println("The CloneVelume is : " + myCloneShipment.velume());
		System.out.println("The cost of the CloneShipment  is : " + myCloneShipment.cost);
	}

}
