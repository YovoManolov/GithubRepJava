import javax.swing.*;
	public class MyTable {
			JFrame f;
		MyTable(){
			f = new JFrame();
			
			String column[]={"ID","NAME","SALARY"};
			String data[][] = { {"101","Amit","670000"},
					             {"102","Jai","780000"},
		                         {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"},
					             {"103","Sachin","700000"}};
			
			JTable jt = new JTable(data,column);
			jt.setBounds(30,40,200,300);
			JScrollPane js = new JScrollPane(jt);
			f.add(js);
			
			f.setSize(500,400);
			   //f.setLayout(null);
				f.setVisible(true);
			
		}
			public static void main(String[] args) {
				new MyTable();
			}
}