package main;

import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;

public interface NumberToEnglishWords_I {
	public String convert(@PathParam("number") long number);
}
