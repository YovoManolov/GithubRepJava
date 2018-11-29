package com.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numberToConvert = request.getParameter("numberToConvert");
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/NumberToEnglishWords/convertNumberToWords/convert/"+numberToConvert);
		ClientResponse resp = webResource.accept("text/html").get(ClientResponse.class);
		
		String numberToWordsString  = null;
		if(resp.getStatus() == 200) {
			numberToWordsString = resp.getEntity(String.class);
		}
			
		request.setAttribute("numberToWordsString", numberToWordsString);
		request.getRequestDispatcher("client.jsp").forward(request, response);
		
		doGet(request, response);
	}
	
	
}
