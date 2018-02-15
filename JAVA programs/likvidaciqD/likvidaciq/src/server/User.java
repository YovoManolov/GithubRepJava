package server;

import java.util.ArrayList;

public class User {

	String email;
	String pass;
	ArrayList<Grade> grades;
	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}
	
}
