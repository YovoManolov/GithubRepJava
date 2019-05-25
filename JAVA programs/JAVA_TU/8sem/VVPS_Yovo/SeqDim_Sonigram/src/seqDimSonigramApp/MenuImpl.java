package seqDimSonigramApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMining;
import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMiningClosed;
import ca.pfv.spmf.test.MainTestOPTICS_extractClusterOrdering_saveToFile;
import ca.pfv.spmf.test.MainTestOPTICS_extractDBScan_saveToFile;
import seqDimSonigramApp.dataModels.LogData;
import seqDimSonigramApp.dataModels.LogEntity;
import seqDimSonigramApp.dataModels.UserFilterInputData;
import seqDimSonigramApp.fileHandling.AlgoInputFileWriter;
import seqDimSonigramApp.fileHandling.AlgoOutputFileReader;
import seqDimSonigramApp.utils.StringConstants;

public class MenuImpl {
	
	private static int USER_ID_MIN = 1;
	private static int USER_ID_MAX = 7397;
	private static int EXIT = 4;
	
	UserFilterInputData userFilterInputData = new UserFilterInputData();
	
	public void startMenu() {
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			for(int currentIndex = 0; currentIndex < UserFilterInputData.SIZE_OF_MDS; currentIndex++) {
				userFilterInputData.takeInputChoice(sc,currentIndex);
				choice = 1;
			}
			
			switch(choice) {
				case 1:
					findEventContextsByUserId(userFilterInputData);
					break;
				default: break;
			}
		} while(choice != EXIT);
		System.out.println(StringConstants.EXIT_APPLICATION);
		sc.close();
	}

		
	private static int takeInputUserId(Scanner sc) {
		System.out.println("Enter user id:");
		if(sc == null) {
			sc = new Scanner(System.in);
		} 
		
		try {
			int userId = Integer.parseInt(sc.nextLine());
			if(userId < USER_ID_MIN || userId > USER_ID_MAX) {
				System.out.println(StringConstants.ENTER_VALID_USER_ID);
				return takeInputUserId(sc);
			}
			return userId;
		} catch (NumberFormatException e) {
			System.out.println(StringConstants.ENTER_VALID_USER_ID);
			return takeInputUserId(sc);
		}
	}
	
	private static void printMenu() {
		System.out.println(StringConstants.MENU);
	}
	
	
    private static void findEventContextsByUserId(UserFilterInputData userFilterInputData) {
		
    	ArrayList<List<LogEntity>> findResultsForEachRow = new ArrayList<List<LogEntity>>();
		//found contexts for chosen user
    	findResultsForEachRow.add(
        		LogData.getFullLogData().stream()
    			.filter(el -> 
    					el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(0) )
    					&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(0) )
    					&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(0) )
    			).collect(Collectors.toList())
    	);
    	
    	findResultsForEachRow.add(
        		LogData.getFullLogData().stream()
    			.filter(el -> 
    					el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(1) )
    					&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(1) )
    					&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(1) )
    			).collect(Collectors.toList())
    	);
    	
    	findResultsForEachRow.add(
        		LogData.getFullLogData().stream()
    			.filter(el -> 
    					el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(2) )
    					&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(2) )
    					&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(2) )
    			).collect(Collectors.toList())
    	);
    	
    	findResultsForEachRow.add(
        		LogData.getFullLogData().stream()
    			.filter(el -> 
    					el.getEventContext().equals( userFilterInputData.getChosenEventContexts().get(3) )
    					&& el.getComponent().equals( userFilterInputData.getChosenComponents().get(3) )
    					&& el.getEventName().equals( userFilterInputData.getChosenEventNames().get(3) )
    			).collect(Collectors.toList())
    	);
    	
    	try {
				AlgoInputFileWriter algoInput = new AlgoInputFileWriter();
				algoInput.writeList(findResultsForEachRow);

				executeAlgorithms();

				AlgoOutputFileReader outputAlgo = new AlgoOutputFileReader();
				List<String> clusters = outputAlgo.getClusters(LogData.getLogEventContexts());
				for(String cluster : clusters) {
					System.out.println(cluster);
				}

		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}

	private static void executeAlgorithms() throws NumberFormatException, IOException {
		MainTestMultiDimSequentialPatternMiningClosed.main(null);
	}
}
