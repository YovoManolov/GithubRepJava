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

	public void takeInputChoice(Scanner sc) {	
		
		if(sc == null) {
			sc = new Scanner(System.in);
		} 
		
		try {
			int menuChoice  = sc.nextInt();
			if(menuChoice != 1) {
				return;
			}else {
				DropDownSelectionListsImpl downSelectionListsImpl = new DropDownSelectionListsImpl();
				
				int[] componentsChoices = new int[SIZE_OF_MDS];
				int[] eventContextChoices = new int[SIZE_OF_MDS];
				int[] eventNamesChoices = new int[SIZE_OF_MDS];
				
				/*int[] eventContextChoices = new int[] {7,35,10,41};
				int[] componentsChoices = new int[] {8,8,8,8};
				int[] eventNamesChoices = new int[] {23,23,23,23};*/
			
				
				downSelectionListsImpl.listAllComponents();
				System.out.println("\nPlease enter the numbers of the selected components:  ");
				for(int i = 0 ; i < SIZE_OF_MDS ;i++) {
					componentsChoices[i] = sc.nextInt();
				}
				
				downSelectionListsImpl.listAllEventContexts();
				System.out.println("\nPlease enter the number of the selected event context:  ");
				for(int i = 0 ; i < SIZE_OF_MDS ;i++) {
					eventContextChoices[i] = sc.nextInt();
				}
				
				downSelectionListsImpl.listAllEventNames();
				System.out.println("\nPlease enter the number of the selected event name:  ");
					for(int i = 0 ; i < SIZE_OF_MDS ;i++) {
					eventNamesChoices[i] = sc.nextInt();
				}
					
				for(int i = 0 ; i < SIZE_OF_MDS ;i++) {
					chosenEventContexts.add(downSelectionListsImpl.getSelectedEventContexts(eventContextChoices[i]));
					chosenComponents.add(downSelectionListsImpl.getSelectedComponent(componentsChoices[i]));
					chosenEventNames.add(downSelectionListsImpl.getSelectedEventNames(eventNamesChoices[i]));
				}
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println(StringConstants.MENU_CHOICE);
			return ;
		}
	}

}
