/*
 *  Swing by inheritance
 */
import javax.swing.*;

public class Simple2 extends JFrame{

	JFrame f ;
	Simple2(){
		
		JButton b = new JButton("IME");
		
		
		// FOUR ARG FOR BOUNDS " (int xaxis, int yaxis, int width, int height)
		b.setBounds(130,100,100,40);
		
		add(b); // ADDING BUTTON TO THE FRAME
		
		
		//FRAME : SIZE ,, LAYOUT ,, VISIBLE
		setSize(400 ,300); //Setting size on the frame
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Simple2();
	}

}
