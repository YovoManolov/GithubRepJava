
package Secretary;

import Server.Server;
import Student.Document;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yovo
 */
public class Secretary {
    public static void main(String[] args) {
      final String  password = "secret";
        
        
        ObjectInputStream oin ;
        ObjectOutputStream out ;
        Document doc;
        
    
             try{
                 Socket s = new Socket("localhost",5001);
                 oin = new ObjectInputStream(s.getInputStream());
                 out = new ObjectOutputStream(s.getOutputStream());
                 try{
                     out.writeObject(password);
                     
                     if(!((String)oin.readObject()).equals("OK")){
                         System.out.println("Bad password");
                         return;
                     }
                     
                     String doctype = (String)oin.readObject();
                     if(doctype.equals("normal")){
                         doc = (Document) oin.readObject();
                         if(doc.success < 5.50){
                             System.out.println("success is not enought for normal scholarship");
                         }else if(doc.incomPerPerson > 500){
                             System.out.println("Student's incom per person is to high to take"
                                     + "success scholarship");
                         }
                         else{
                            Socket s1 = new Socket("localhost",5002);
                            oin = new ObjectInputStream(s1.getInputStream());
                            out = new ObjectOutputStream(s1.getOutputStream()); 
                            
                            out.writeObject(password);
                            if(!((String)oin.readObject()).equals("OK")){
                                System.out.println("Bad password");
                                System.out.println("couldnt connect to server");
                                return;
                            }
                            
                            out.writeObject(doc.name);
                            int numberOfAcceptedAplications = oin.readInt();
                            if(numberOfAcceptedAplications > 5){
                                System.out.println("The application was not approved "
                                        + "because there are to many approved applications"
                                        + "from the specific student ");
                            }
                            else {
                                System.out.println("Approved special application " + doc.name);
                                int currentApprovedApplications = Server.studentInfo.get(doc.name);
                                Server.studentInfo.put(doc.name,currentApprovedApplications+1);
                            }
                          }
                      }
                       if(doctype.equals("special")){
                         doc = (Document) oin.readObject();
                         if(doc.success < 5.30){
                             System.out.println("success is not enought for special scholarship");
                         }else if(doc.incomPerPerson > 300){
                             System.out.println("Student's incom per person is to high to take"
                                     + "special scholarship");
                         }
                         else{
                            Socket s1 = new Socket("localhost",5002);
                            oin = new ObjectInputStream(s1.getInputStream());
                            out = new ObjectOutputStream(s1.getOutputStream()); 
                            
                            out.writeObject(password);
                            if(!((String)oin.readObject()).equals("OK")){
                                System.out.println("Bad password");
                                System.out.println("couldnt connect to server");
                                return;
                            }
                            
                            out.writeObject(doc.name);
                            int numberOfAcceptedAplications = oin.readInt();
                            if(numberOfAcceptedAplications > 4){
                                System.out.println("The application was not approved "
                                        + "because there are to many approved applications"
                                        + "from the specific student ");
                            }
                            else {
                                System.out.println("Approved special application " + doc.name);
                                int currentApprovedApplications = Server.studentInfo.get(doc.name);
                                Server.studentInfo.put(doc.name,currentApprovedApplications+1);
                            }
                         }
                     }else {
                           System.out.println("Wrong doctype");
                     }
                     
                 } catch (IOException ex) {
                     System.out.println("Cannot connect !!! ");
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Secretary.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             } catch (IOException ex) {
            Logger.getLogger(Secretary.class.getName()).log(Level.SEVERE, null, ex);
            }
  
    }
}
