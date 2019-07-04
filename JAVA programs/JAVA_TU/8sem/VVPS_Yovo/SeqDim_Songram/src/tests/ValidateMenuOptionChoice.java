package tests;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import seqDimSonigramApp.dataModels.MDPatternType;
import seqDimSonigramApp.dataModels.UserFilterInputData;

class ValidateMenuOptionChoice {

	UserFilterInputData userFilterInputData = new UserFilterInputData();
	@Test
	void testMainMenuValidInput() {

		Scanner sc = new Scanner(System.in);
		Integer returnedValue =  userFilterInputData.takeInputChoiceUnit("1");
		
		assertTrue(returnedValue == 1);
	}
	
	@Test
	void testMainMenuInvalidInput() {
		
		Boolean success = true ;
		
		Integer returnedValue =  userFilterInputData.takeInputChoiceUnit("-1");
		if(((int)returnedValue) != -1 ) success = false;
		
		returnedValue =  userFilterInputData.takeInputChoiceUnit("testInput");
		if(((int)returnedValue) != -1 ) success = false;

		returnedValue =  userFilterInputData.takeInputChoiceUnit("3.14");
		if(((int)returnedValue) != -1 ) success = false;
		
		assertTrue(true == success);
	}
}
