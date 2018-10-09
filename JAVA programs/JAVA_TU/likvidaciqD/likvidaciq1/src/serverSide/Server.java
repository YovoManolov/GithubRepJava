package serverSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
	private ServerSocket serverSocket;
  
	final static ArrayList<Offert> offerts = new ArrayList<>();
	final static ArrayList<User> users = new ArrayList<>();
	
   
	 public Server(int port) throws IOException {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(10000);
	}

	 
	 public void run() {
		 while(true) {
		 try (
				Socket s = serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream()); 
				ObjectInputStream in = new ObjectInputStream(s.getInputStream()) 
				){
			     
			    String userEmail, userPassword;
			    		
			 	users.add(new User("someEmailAddr","pass"));
			 	users.add(new User("someEmailAddr2","pass2"));
			 	users.add(new User("someEmailAddr3","pass3"));
			 
				offerts.add(new Offert(1, "Sofia", "Aris", 10.5, 6,new ArrayList<Integer>()));
		    	offerts.add(new Offert(2, "Sofia", "Aris2", 11.5, 6,new ArrayList<Integer>()));
		    	offerts.add(new Offert(3, "Sofia", "Aris3", 11.6, 6,new ArrayList<Integer>()));
		    	offerts.add(new Offert(4, "Plovdiv", "BAris2", 11.5, 6,new ArrayList<Integer>()));
		    	offerts.add(new Offert(5, "Plovdiv", "BAris3", 12.5, 6,new ArrayList<Integer>()));
		    	offerts.add(new Offert(6, "Varna", "CAris3", 9.5, 6,new ArrayList<Integer>()));
				
				ArrayList<String> destList = new ArrayList<String>();
				for (Offert offert : offerts) {
			        	destList.add(offert.getDestination());
			     }
				
				userEmail = in.readUTF();
				userPassword = in.readUTF();
				
				for(User u : users) {
					if(u.getEmail().equals(userEmail) && u.getPass().equals(userPassword)){				
						out.writeUTF("Send doctype: \"reservation\" or \"rating\"");
			            out.flush();
			        
			            String option = in.readUTF();
			            if (option.equals("reservation")){
			                out.writeObject(destList);
			                out.flush();
			             
			             ArrayList<Offert> destOfferts = new ArrayList<Offert>();
			             String selectedDestination = in.readUTF();
			             
			             for (Offert offert : offerts) {
					        if(offert.getDestination().equals(selectedDestination)){
					        	destOfferts.add(offert);
					        }
					     }
			             
			             out.writeObject(destOfferts);
			             
			             int offerIdFromCl = in.readInt();
			             
			            u.getGrades().add(new Grade(offerIdFromCl,false));
			           } else if(option.equals("rating")){
			        	   
				        	 out.writeUTF("send offertId");
				        	 
				        	 int offerIdFromCl = in.readInt();
				        	
				            
						    for(Grade g: u.getGrades()){
						       if(g.getOffertID() == offerIdFromCl) {
						        	if(g.isEvaluation() == false) {
						        		out.writeUTF("Enter your grade from 1 to 6");
						        		
						        	}
						       }
						    }
				             
			            }

					}
				}
				System.out.println("User not found! Wrong email or password");
	         
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	
	public static void main(String [] args) {
		try {
		    Thread t = new Server(1234);
		    t.start();
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	
 

}