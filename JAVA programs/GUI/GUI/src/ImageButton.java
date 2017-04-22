import javax.swing.*;
import java.awt.event.*;

 
public class ImageButton{

  ImageButton(){
	//FRAME : SIZE ,, LAYOUT ,, VISIBLE
		JFrame f = new JFrame();
		JButton b= new JButton("MAGI");  
		b.setBounds(50, 100,100 ,40 );
		
		f.add(b);
		
		f.setSize(300,400);
		f.setLayout(null);
		f.setVisible(true);

		
  }

  public static void main(String[] args) {
		// TODO Auto-generated method stub
       new ImageButton();
	}

}
	
