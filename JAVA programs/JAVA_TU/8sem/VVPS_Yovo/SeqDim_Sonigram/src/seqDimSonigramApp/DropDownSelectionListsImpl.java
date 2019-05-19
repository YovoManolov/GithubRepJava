package seqDimSonigramApp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DropDownSelectionListsImpl {
	
	private List<String> allEventNames;
	private List<String> allEventContexts;
	private List<String> allComponents;
	
	public DropDownSelectionListsImpl(
					LinkedList<String> allEventNames, 
					LinkedList<String> allEventContexts,
					LinkedList<String> allComponents 
			) {
		super();
		loadAllComponents();
		loadAllEventContexts();
		loadAllEventNames();
	}
	
	//	========================================================
	// Components
	//	========================================================
	public void listAllComponents() {
		//found contexts for chosen user
		System.out.println();
		for(int i = 0;i< allComponents.size(); i++) {
			System.out.println( (i+1) + ": " + allComponents.get(i));
		}
	}

	public String getSelectedComponent(Scanner sc) {
		return allComponents.get( sc.nextInt() - 1);
	}
	
	//	========================================================
	// EventContexts
	//	========================================================
	public void listAllEventNames() {
		//found contexts for chosen user
		System.out.println();
		for(int i = 0;i< allEventNames.size(); i++) {
			System.out.println( (i+1) + ": " + allEventNames.get(i));
		}
	}

	public String getSelectedEventNames(Scanner sc) {
		return allEventContexts.get( sc.nextInt() - 1);
	}
	
	//	========================================================
	// EventContexts
	//	========================================================
	public void listAllEventContexts() {
		//found contexts for chosen user
		System.out.println();
		for(int i = 0;i< allEventContexts.size(); i++) {
			System.out.println( (i+1) + ": " + allEventContexts.get(i));
		}
	}

	public String getSelectedEventContexts(Scanner sc) {
		return allEventContexts.get(sc.nextInt() - 1);
	}
	
	//	========================================================
	private void loadAllEventContexts() {
		// TODO Auto-generated method stub
		allEventContexts = LogData.getFullLogData().stream()
				.map(LogEntity::getEventContext).distinct()
				.collect(Collectors.toList());
	}
	
	private void loadAllComponents() {
		// TODO Auto-generated method stub
		allComponents = LogData.getFullLogData().stream()
				.map(LogEntity::getComponent).distinct()
				.collect(Collectors.toList());
	}
	
	private void loadAllEventNames() {
		// TODO Auto-generated method stub
		allComponents = LogData.getFullLogData().stream()
				.map(LogEntity::getEventName).distinct()
				.collect(Collectors.toList());
	}
}
