/*
 * public void setRows(int Rows) - used to set specified numer of rows
 * public void setColumns(int cols) - used to set specified numer columns
 * public void setFont(Font f) - used to set the specified fort
 * public void insert (String s, int position) - used to specified text on the specified position
 * public void append(String s) - used to append the givven text to the end of the document
 * 	*/


import javax.swing.*;

import java.awt.Color;
import java.awt.color.*;

public class TArrea {
 
    JTextArea arrea;  
	JFrame frame;
	
	TArrea(){
		frame = new JFrame();
		
		
	    arrea = new JTextArea(300, 300);
	    arrea.setBounds(10,30,300,300);
	    arrea.setBackground(Color.black);
	    arrea.setForeground(Color.white);

	    
		frame.add(arrea);
		
		frame.setVisible(true);
		frame.setSize(400,400);
		frame.setLayout(null);
	}
	public static void main(String[]args){
		 new TArrea();
	}
}
