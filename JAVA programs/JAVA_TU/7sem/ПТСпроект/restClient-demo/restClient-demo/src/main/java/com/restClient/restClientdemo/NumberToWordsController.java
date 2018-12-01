package com.restClient.restClientdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
public class NumberToWordsController {
	
	  	@GetMapping("/enterNumber")
	    public String greetingForm(Model model) {
	        model.addAttribute("numberToWordsModel", new NumberToWordsModel());
	        return "getNumber";
	    }

	    @PostMapping("/result")
	    public String greetingSubmit(@ModelAttribute 
	    				NumberToWordsModel numberToWordsModel) {
	    	
	    	String numberToConvert = numberToWordsModel.getNumberFromInputField();
	    	
	    	Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/NumberToEnglishWords/convertNumberToWords/convert/"+numberToConvert);
			String numberToWordsString = webResource.accept("text/plain").get(String.class);
		
	    	numberToWordsModel.setNumberToString(numberToWordsString);
	    	
	        return "result";
	    }
}
