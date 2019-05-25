package seqDimSonigramApp.dataModels;

import java.util.ArrayList;
import java.util.Scanner;

import seqDimSonigramApp.DropDownSelectionListsImpl;
import seqDimSonigramApp.utils.StringConstants;

public class UserFilterInputData {
	
	public static int SIZE_OF_MDS = 4; //multi-dimensional sequences
	
	private ArrayList<String> chosenComponents = new ArrayList<>() ;
	private ArrayList<String> chosenEventContexts = new ArrayList<>() ;
	private ArrayList<String>  chosenEventNames = new ArrayList<>() ;
	
	
	public ArrayList<String> getChosenComponents() {
		return chosenComponents;
	}

	public void setChosenComponents(ArrayList<String> chosenComponents) {
		this.chosenComponents = chosenComponents;
	}

	public ArrayList<String> getChosenEventContexts() {
		return chosenEventContexts;
	}

	public void setChosenEventContexts(ArrayList<String> chosenEventContexts) {
		this.chosenEventContexts = chosenEventContexts;
	}

	public ArrayList<String> getChosenEventNames() {
		return chosenEventNames;
	}

	public void setChosenEventNames(ArrayList<String> chosenEventNames) {
		this.chosenEventNames = chosenEventNames;
	}

	public void takeInputChoice(Scanner sc,Integer currentArrayIndex) {
		
		System.out.println("Find most frequent IPs by Event context, component and eventName.");
		
		if(sc == null) {
			sc = new Scanner(System.in);
		} 
		
		try {
			int menuChoice  = sc.nextInt();
			if(menuChoice != 1) {
				return;
			}else {
				DropDownSelectionListsImpl downSelectionListsImpl = new DropDownSelectionListsImpl();
				
				for(int i = 0 ; i < SIZE_OF_MDS ;i++) {
					chosenComponents.add(downSelectionListsImpl.makeAChoiceForComponents(sc));
					chosenEventContexts.add(downSelectionListsImpl.makeAChoiceForEventContexts(sc));
					chosenEventNames.add(downSelectionListsImpl.makeAChoiceForEventNames(sc));
				}
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println(StringConstants.MENU_CHOICE);
			return ;
		}
	}

}
