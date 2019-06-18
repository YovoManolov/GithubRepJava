package seqDimSonigramApp.utils;

public final class StringConstants {
	 private StringConstants() {
         // restrict instantiation
	 }
	 
	 public static final String ENTER_VALID_USER_ID = 
			 		"Please enter user id - whole number between 0 and 7398!\n";
	 
	 public static final String MENU = 
							 "\n||=================== MENU ===================||"+
							 "\n|| 1. Run SeqDim Songram algorithm.===========||"+
							 "\n|| 2. Exit.===================================||\n";
	 
	 public static final String EXIT_APPLICATION = "\nApplication terminated by user! Bye-bye.";
	 public static final String MENU_CHOICE = "Please choose an option from the menu!\n";

	 public static final String INVALID_MENU_CHOICE = "Please choose a valid option from the menu!\n";
	 public static final String MD_PATTERN_TYPE_CHOICE = "Please enter the number of the selected ";
	 
	 public static final String NO_DATA_FOUND_FOR_USER_CHOICE =  
			 			"\nNo data found for the following user choice: ";
	 
	 public static final String MD_PATTERN_TYPE_CONTEXTS ="event context";
	 public static final String MD_PATTERN_TYPE_COMPONENTS ="component";
	 public static final String MD_PATTERN_TYPE_EVENT_NAMES ="event name";
}
