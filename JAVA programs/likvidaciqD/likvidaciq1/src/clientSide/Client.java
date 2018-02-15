package clientSide;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import serverSide.Offert;
import serverSide.User;

public class Client {
	
	  public static void main(String [] args) {
	      String serverName = args[0];
	      int port = Integer.parseInt(args[1]);
	      try {
	    	
	         System.out.println("Connecting to localhost on port " + port);
	         Socket s = new Socket("localhost", 1234);
	         System.out.println("Just connected to " + s.getRemoteSocketAddress());
	         
	         Scanner sc = new Scanner(System.in);
	         
	         ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
	         ObjectInputStream in = new ObjectInputStream(s.getInputStream());
	         
	         System.out.println("Please enter email addr: ");
	         out.writeUTF(sc.nextLine());
	         System.out.println("Please enter password: ");
	         out.writeUTF(sc.nextLine());
	         
	         ArrayList<String> destList = (ArrayList<String>) in.readObject();
	         System.out.println("Please choose one from the following destinations: ");
	         System.out.println(destList);
	         
	         out.writeUTF(sc.nextLine());
	         out.flush();
	         
	         System.out.println("Those are the offerts from the dest you chose");
	         ArrayList<Offert> offertList = (ArrayList<Offert>) in.readObject();
	         
	         System.out.println(offertList);
             System.out.println("Please select name of Hotel");
             
             String nameOfHotel = sc.nextLine();
             
             for (Offert offert : offertList) {
			        if(offert.getNameOfHotel().equals(nameOfHotel)){
			        	out.writeInt(offert.getOffertID());
			        }
			 }
	        
	         
	         s.close();
	      } catch (IOException | ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	   }
}
