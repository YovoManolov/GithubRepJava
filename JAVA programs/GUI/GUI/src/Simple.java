import javax.swing.*;

public class Simple {
    JFrame f;
    
    Simple(){
    	
    f = new JFrame();
    f.setSize(300,200);
    f.setLayout(null);
    f.setVisible(true);
    
    
    JButton b = new JButton("click");
    b.setBounds(130,100, 100,40);
    
    f.add(b);  // Adding the button to the frame 
    }
	public static void main(String[] args) {
		new  Simple();

	}

}
