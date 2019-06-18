package seqDimSonigramApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMiningClosed;
import seqDimSonigramApp.dataModels.LogData;
import seqDimSonigramApp.dataModels.LogEntity;
import seqDimSonigramApp.dataModels.UserFilterInputData;
import seqDimSonigramApp.fileHandling.AlgoInputFileWriter;
import seqDimSonigramApp.utils.StringConstants;

public class MenuImpl {
	
	private static int EXIT = 2;
	
	private UserFilterInputData userFilterInputData = new UserFilterInputData();
	
	public void startMenu() {
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			choice = userFilterInputData.takeInputChoice(sc);
			
			switch(choice) {
				case 1:
					execSeqDim_SongramAlg(userFilterInputData);
					break;
				case 2: break;
				
				default: System.out.println(StringConstants.INVALID_MENU_CHOICE);
			}
		} while(choice != EXIT);
		System.out.println(StringConstants.EXIT_APPLICATION);
		sc.close();
	}

	private static void printMenu() {
		System.out.println(StringConstants.MENU);
	}
	
    private void execSeqDim_SongramAlg(UserFilterInputData userFilterInputData) {
    	
    	ArrayList<List<LogEntity>> findResultsForEachRow = new ArrayList<List<LogEntity>>();
    	
    	loadResultsFromSearchCriterias(findResultsForEachRow);
    	
    	try {
				if(findResultsForEachRow.isEmpty()) {
					System.out.println("No results found in the log for the selected search criterias!");
				}else {
	    			AlgoInputFileWriter algoInput = new AlgoInputFileWriter();
					
					algoInput.writeList(findResultsForEachRow);

					executeAlgorithms();
				}

		} catch (IOException e) {
				e.printStackTrace();
		}
	}

	private void loadResultsFromSearchCriterias(
		 	 ArrayList<List<LogEntity>> findResultsForEachRow) {
		
		List<LogEntity> singleLogEntityList ;
		singleLogEntityList = LogData.getFullLogData().stream()
				.filter(el -> 
						el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(0) )
						&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(0) )
						&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(0) )
				).collect(Collectors.toList());
		    	if(!singleLogEntityList.isEmpty()) {
		    		findResultsForEachRow.add(singleLogEntityList);
		    	}
		    	singleLogEntityList = LogData.getFullLogData().stream()
				.filter(el -> 
						el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(1) )
						&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(1) )
						&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(1) )
				).collect(Collectors.toList());
		    	if(!singleLogEntityList.isEmpty()) {
		    		findResultsForEachRow.add(singleLogEntityList);
		    	}
		    	singleLogEntityList = LogData.getFullLogData().stream()
				.filter(el -> 
						el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(2) )
						&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(2) )
						&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(2) )
				).collect(Collectors.toList());
		    	if(!singleLogEntityList.isEmpty()) {
		    		findResultsForEachRow.add(singleLogEntityList);
		    	}
		    	
		    	singleLogEntityList = LogData.getFullLogData().stream()
		    			.filter(el -> 
						el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(3) )
						&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(3) )
						&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(3) )
				).collect(Collectors.toList());
		    	if(!singleLogEntityList.isEmpty()) {
		        	findResultsForEachRow.add(singleLogEntityList);
		    	}
		    	
		   return;
	}

	private static void executeAlgorithms() throws NumberFormatException, IOException {
		MainTestMultiDimSequentialPatternMiningClosed.main(null);
	}
}
