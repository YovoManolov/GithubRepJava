package com.restClient.restClientdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	    	
	    	if(isValidNumber(numberToConvert)) {
	    		numberToConvert = numberToConvert.trim();
	    		Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/NumberToEnglishWords/convertNumberToWords/convert/"+numberToConvert);
				String numberToWordsString = webResource.accept("text/plain").get(String.class);
		    	numberToWordsModel.setNumberToString(numberToWordsString);
		    	
		    	return "result";
			}else {
				numberToWordsModel.setErrorMessage("You have used invalid input."+"\n"+
							"Please use positive integer value!");
				return "getNumber";
			}
	  }
	    
	  private boolean isValidNumber(String integerNumber) {
		  
		  String regex = "^(\\s+|^)[+]?\\d+(\\s+|$)$";
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(integerNumber);
		  
		  return matcher.matches();
	  }
}
