package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import seqDimSonigramApp.dataModels.MDPatternType;
import seqDimSonigramApp.dataModels.UserFilterInputData;

class ValidateDimensionsOptionsChoice {
	
	UserFilterInputData userFilterInputData = new UserFilterInputData();
	
	//Components
	@Test
	void testOptionsComponentsValid() {
		Integer returnedValue =  userFilterInputData.getChoiceUnit("9",MDPatternType.COMPONENTS);
		assertTrue((int)returnedValue > 0 );
	}
	
	@Test
	void testOptionsComponentsInvalid() {
		Boolean success = true ;
		
		Integer returnedValue =  userFilterInputData.getChoiceUnit("-13",MDPatternType.COMPONENTS);
		if((int)returnedValue != -1 ) success = false;

		returnedValue =  userFilterInputData.getChoiceUnit("testInput",MDPatternType.COMPONENTS);
		if((int)returnedValue != -1 ) success = false;
		
		returnedValue =  userFilterInputData.getChoiceUnit("3.14",MDPatternType.COMPONENTS);
		if((int)returnedValue != -1 ) success = false;
		
		assertTrue (true == success);
	}
	
	//Event names
	@Test
	void testOptionsEventNamesValid() {
		Integer returnedValue =  userFilterInputData.getChoiceUnit("30",MDPatternType.EVENT_NAMES);
		assertTrue((int)returnedValue > 0 );
	}
	
	@Test
	void testOptionsEventNamesInvalid() {
		Boolean success = true ;
		Integer returnedValue =  userFilterInputData.getChoiceUnit("-13",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 )success = false;
		
		returnedValue =  userFilterInputData.getChoiceUnit("testInput",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 ) success = false;
		
		returnedValue =  userFilterInputData.getChoiceUnit("3.14",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 ) success = false;
		
		assertTrue (true == success);
	}
	
	//Event contexts
	@Test
	void testOptionsEventContextValid() {
		Integer returnedValue =  userFilterInputData.getChoiceUnit("39",MDPatternType.EVENT_CONTEXTS);
		assertTrue((int)returnedValue > 0 );
		
	}
	
	@Test
	void testOptionsEventContextInvalid() {
		Boolean success = true ;
		Integer returnedValue =  userFilterInputData.getChoiceUnit("-13",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 )success = false;
		
		returnedValue =  userFilterInputData.getChoiceUnit("testInput",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 ) success = false;
		
		returnedValue =  userFilterInputData.getChoiceUnit("3.14",MDPatternType.EVENT_NAMES);
		if((int)returnedValue != -1 ) success = false;
		
		assertTrue (true == success);
	}
	
}
