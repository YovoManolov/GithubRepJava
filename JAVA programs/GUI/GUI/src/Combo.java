import javax.swing.*;

public class Combo{
	JFrame f;
	  Combo(){
		  f = new JFrame("Combo ex");  
		  int[] bithYearBox = {432,4,342,432,23,4,234};
		  
		  //JComboBox<Integer> birthYearBox = new JComboBox<>(birthYear);
		  JComboBox<Integer> by = new JComboBox<>(BirhtYearBox);
		  
		  
		   by.setBounds(50,50,90,20);
		   f.add(by);
		 
		 f.setLayout(null);  
		 f.setSize(400,500);
		 f.setVisible(true);
	  }
		
		public static void main(String[] args) {
			new Combo();
		}

}
