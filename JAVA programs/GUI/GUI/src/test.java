

import javax.swing.*; 
import java.awt.*;


public class test {
	
	   public test {
			gui();
		}
	   
	    private JFrame f;
		private JPanel p;
		private JButton b1;
		private JLabel lab;

		

	
		public void gui(){
		// Creating frame
		f = new JFrame("Creativity tuts");
		f.setVisible(true);
		f.setSize(600,400);	  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		p = new JPanel();
		p.setBackground(Color.YELLOW);
		
		b1 = new JButton("test");
		lab = new JLabel("This is test Label");
		
		p.add(b1);
		p.add(lab);
		
		f.add(p);
		}

		public static void main(String[] args) {
			new test ();		
		}	
}

