import javax.swing.*;

public class Radio {
   JFrame f;
	Radio(){
		f = new JFrame();
		
		JRadioButton r1 = new JRadioButton("A) Male");
		JRadioButton r2 = new JRadioButton("B) FeMale");
		
		JRadioButton r3 = new JRadioButton("A) Male2");
		JRadioButton r4 = new JRadioButton("B) FeMale2");
		
		r1.setBounds(50,100,70,50);
		r2.setBounds(50,150,70,50);
		
		r3.setBounds(100,200,70,50);
		r4.setBounds(100,250,70,50);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		ButtonGroup bg2 = new ButtonGroup();
		
		bg2.add(r3);
		bg2.add(r4);
		
		f.add(r1 ); f.add(r2);
		f.add(r3 ); f.add(r4);
		
		
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new Radio();
	}

}
