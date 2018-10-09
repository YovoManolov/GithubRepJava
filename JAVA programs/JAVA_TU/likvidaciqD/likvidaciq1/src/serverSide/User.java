package serverSide;

import java.util.ArrayList;

public class User {

	private String email;
	private String pass;
	private ArrayList<Grade> grades;
	
	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
		grades = new ArrayList<Grade>();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}
}
