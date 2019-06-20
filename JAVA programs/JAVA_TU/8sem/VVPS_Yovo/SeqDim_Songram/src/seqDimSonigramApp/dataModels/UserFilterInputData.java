package seqDimSonigramApp.dataModels;

import java.util.ArrayList;
import java.util.Scanner;

import seqDimSonigramApp.DropDownSelectionListsImpl;
import seqDimSonigramApp.utils.Constants;

public class UserFilterInputData {
	

	
	private ArrayList<String> chosenComponents = new ArrayList<>() ;
	private ArrayList<String> chosenEventContexts = new ArrayList<>() ;
	private ArrayList<String>  chosenEventNames = new ArrayList<>() ;
	
	private MdPatternChoices eventContextChoices = new MdPatternChoices(MDPatternType.EVENT_CONTEXTS);
	private MdPatternChoices componentsChoices = new MdPatternChoices(MDPatternType.COMPONENTS);
	private MdPatternChoices eventNamesChoices = new MdPatternChoices(MDPatternType.EVENT_NAMES);
	
	
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

	public int takeInputChoice(Scanner sc) {	
		
		if(sc == null) {
			sc = new Scanner(System.in);
		} 
		
		try {
			String menuChoice  = sc.next();
			
			int intMenuChoice =  Integer.parseInt(menuChoice);
			if(intMenuChoice != 1) {
				return intMenuChoice;
			}else {
				DropDownSelectionListsImpl downSelectionListsImpl = new DropDownSelectionListsImpl();
				
				/* 
				int[] eventContextChoices = new int[] {7,35,10,41};
				int[] componentsChoices = new int[] {8,8,8,8};
				int[] eventNamesChoices = new int[] {23,23,23,23};*/
				
				downSelectionListsImpl.listAllEventContexts();
				loadSelectedMDPatterns(Constants.MD_PATTERN_TYPE_CONTEXTS,eventContextChoices,sc);
				
				downSelectionListsImpl.listAllComponents();
				loadSelectedMDPatterns(Constants.MD_PATTERN_TYPE_EVENT_NAMES,componentsChoices,sc);
				
				downSelectionListsImpl.listAllEventNames();
				loadSelectedMDPatterns(Constants.MD_PATTERN_TYPE_EVENT_NAMES,eventNamesChoices,sc);
				
				for(int i = 0 ; i < Constants.SIZE_OF_MDS ;i++) {
					
					chosenEventContexts.add(downSelectionListsImpl.getSelectedEventContexts(eventContextChoices.getChoiceAtIndex(i)));
					chosenComponents.add(downSelectionListsImpl.getSelectedComponent(componentsChoices.getChoiceAtIndex(i)));
					chosenEventNames.add(downSelectionListsImpl.getSelectedEventNames(eventNamesChoices.getChoiceAtIndex(i)));
				}
			}
			return intMenuChoice;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private void loadSelectedMDPatterns(String MD_PatternType,MdPatternChoices mdPatternChoices, Scanner sc){
		
		System.out.println("\n" + Constants.MD_PATTERN_TYPE_CHOICE + MD_PatternType+":  ");

		for(int i = 0 ; i < Constants.SIZE_OF_MDS ;) {
			int choice = getChoice(sc,mdPatternChoices.getType());
			
			if( choice != -1) {
				mdPatternChoices.setChoiceAtIndex(i, choice);
				i++;
			}else {
				System.out.println(Constants.INVALID_MD_PATTERN_CHOICE);
				continue;
			}
		}
		return;
	}

	private int getChoice(Scanner sc,MDPatternType mdPatternType) {
		
		String mdPatternChoice  = sc.next();
		int mdPatternChoiceInt;
		try {
			mdPatternChoiceInt =  Integer.parseInt(mdPatternChoice);
		}catch(NumberFormatException e) {
			return  -1;
		}
		
		switch(mdPatternType) {
			case COMPONENTS :
					if(mdPatternChoiceInt > LogData.getLogComponents().size() - 1 ||  mdPatternChoiceInt < 0) {
						return -1;
					}
				break;
			case EVENT_CONTEXTS :
					if(mdPatternChoiceInt > LogData.getLogEventContexts().size() - 1 || mdPatternChoiceInt < 0) {
						return -1;
					}
				break; 
			case EVENT_NAMES: 
					if(mdPatternChoiceInt > LogData.getLogEventContexts().size() - 1 || mdPatternChoiceInt < 0) {
						return -1;
					}
				break;
			default:
				break;
		}
		return mdPatternChoiceInt;
	}
}
