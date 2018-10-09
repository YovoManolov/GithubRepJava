package landParcels;

public class AreaException extends Exception {
  /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 
    AreaException(){
    super("Default Exception Message");
    }
    AreaException(String Message){
     super(Message);     
    }
}
    