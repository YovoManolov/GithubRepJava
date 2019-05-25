package seqDimSonigramApp;

import java.util.List;
import java.util.Scanner;

import seqDimSonigramApp.dataModels.LogData;

public class DropDownSelectionListsImpl {
	
	private List<String> allEventNames;
	private List<String> allEventContexts;
	private List<String> allComponents;
	
	public DropDownSelectionListsImpl() {
		super();
		allEventNames = LogData.getLogEventNames();
		allEventContexts = LogData.getLogEventContexts();
		allComponents = LogData.getLogComponents();
	}
	
	
	public String makeAChoiceForComponents(Scanner sc) {
		
		listAllComponents();
		return getSelectedComponent(sc);
	}
	
	public String makeAChoiceForEventNames(Scanner sc) {
		
		listAllEventNames();
		return getSelectedEventNames(sc);
	}
	
	public String makeAChoiceForEventContexts(Scanner sc) {
		
		listAllEventContexts();
		return getSelectedEventContexts(sc);
	}
	
	//	========================================================
	// Components
	//	========================================================
	private void listAllComponents() {
		//found contexts for chosen user
		System.out.println("\n List of all components: ");
		for(int i = 0;i< allComponents.size(); i++) {
			System.out.println( (i+1) + ": " + allComponents.get(i));
		}
	}

	private String getSelectedComponent(Scanner sc) {
		System.out.println("\nPlease enter the number of the selected component:  ");
		return allComponents.get( sc.nextInt() - 1);
	}
	
	//	========================================================
	// EventContexts
	//	========================================================
	private void listAllEventNames() {
		//found contexts for chosen user
		System.out.println("\n List of all event names: ");
		for(int i = 0;i< allEventNames.size(); i++) {
			System.out.println( (i+1) + ": " + allEventNames.get(i));
		}
	}

	private String getSelectedEventNames(Scanner sc) {
		System.out.println("\nPlease enter the number of the selected event name:  ");
		return allEventContexts.get( sc.nextInt() - 1);
	}
	
	
	//	========================================================
	// EventContexts
	//	========================================================
	private void listAllEventContexts() {
		//found contexts for chosen user
		System.out.println("\n List of all event contexts: ");
		for(int i = 0;i< allEventContexts.size(); i++) {
			System.out.println( (i+1) + ": " + allEventContexts.get(i));
		}
	}

	private String getSelectedEventContexts(Scanner sc) {
		System.out.println("\nPlease enter the number of the selected event context:  ");
		return allEventContexts.get(sc.nextInt() - 1);
	}
	
	
}
