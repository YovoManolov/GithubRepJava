package seqDimSonigramApp;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMining;
import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMiningClosed;
import ca.pfv.spmf.test.MainTestOPTICS_extractClusterOrdering_saveToFile;
import ca.pfv.spmf.test.MainTestOPTICS_extractDBScan_saveToFile;

public class MenuImpl {
	
	private static int USER_ID_MIN = 1;
	private static int USER_ID_MAX = 7397;
	private static int EXIT = 4;
	
	public static void startMenu() {
		int choice = 0;
		int userId = 0;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			choice = takeInputChoice(sc);
			if(choice != EXIT) {
				userId = takeInputUserId(sc);
			}
			
			switch(choice) {
				case 1:
					findEventContextsByUserId(userId);
					break;
				/*case 2:
					findComponentsByUserId(userId);
					break;
				case 3:
					findEventsByUserId(userId);
					break;*/
				
				default: break;
			}
		} while(choice != EXIT);
		System.out.println(StringConstants.EXIT_APPLICATION);
		sc.close();
	}

	private static int takeInputChoice(Scanner sc) {
		
		System.out.println("Find most frequent IPs by Event context, component and eventName.");
		
		
		if(sc == null) {
			sc = new Scanner(System.in);
		} 
		
		try {
			
			
			System.out.println("Please enter event context: ");
			listAllEventContexts();
			String eventContext = sc.nextLine().trim();
			System.out.println("Please enter component: ");
			listAllComponents();
			String component = sc.nextLine().trim();
			System.out.println("Please enter event name: ");
			String eventName = sc.nextLine().trim();
			
			if(choice < 1 || choice > 4) {
				System.out.println(StringConstants.MENU_CHOICE);
				return takeInputChoice(sc);
			}
			return choice;
		} catch (NumberFormatException e) {
			System.out.println(StringConstants.MENU_CHOICE);
			return takeInputChoice(sc);
		}
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
	
	
private static void findEventContextsByUserId(Integer userId) {
		
		//found contexts for chosen user
		List<String> foundResults = LogData.getFullLogData().stream()
				.filter(el -> el.getUserIdFromDescription() == userId)
				.map(LogEntity::getEventContext)
				.collect(Collectors.toList());

		if (foundResults.size() > 0) {
			try {
				AlgoInputFileWriter algoInput = new AlgoInputFileWriter();
				algoInput.writeList(foundResults, LogData.getLogEventContexts());

				executeAlgorithms();

				AlgoOutputFileReader outputAlgo = new AlgoOutputFileReader();
				List<String> clusters = outputAlgo.getClusters(LogData.getLogEventContexts());
				for(String cluster : clusters) {
					System.out.println(cluster);
				}
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			noDataFoundForSearchedUser(userId);
		}
	}

	/*private static void findEventContextsByUserId(Integer userId) {
		
		//found contexts for chosen user
		List<String> foundResults = LogData.getFullLogData().stream()
				.filter(el -> el.getUserIdFromDescription() == userId)
				.map(LogEntity::getEventContext)
				.collect(Collectors.toList());

		if (foundResults.size() > 0) {
			try {
				AlgoInputFileWriter algoInput = new AlgoInputFileWriter();
				algoInput.writeList(foundResults, LogData.getLogEventContexts());

				executeAlgorithms();

				AlgoOutputFileReader outputAlgo = new AlgoOutputFileReader();
				List<String> clusters = outputAlgo.getClusters(LogData.getLogEventContexts());
				for(String cluster : clusters) {
					System.out.println(cluster);
				}
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			noDataFoundForSearchedUser(userId);
		}
	}
	
	private static void findComponentsByUserId(Integer userId) {
		List<String> foundResults = LogData.getFullLogData().stream()
				.filter(el -> el.getUserIdFromDescription() == userId)
				.map(LogEntity::getComponent)
				.collect(Collectors.toList());

		if (foundResults.size() > 0) {
			try {
				AlgoInputFileWriter inputAlgo = new AlgoInputFileWriter();
				inputAlgo.writeList(foundResults, LogData.getLogComponents());

				executeAlgorithms();

				AlgoOutputFileReader outputAlgo = new AlgoOutputFileReader();
				List<String> clusters = outputAlgo.getClusters(LogData.getLogComponents());
				for(String cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			noDataFoundForSearchedUser(userId);
		}
	}

	private static void findEventsByUserId(Integer userId) {
		List<String> foundResults = LogData.getFullLogData().stream()
				.filter(el -> el.getUserIdFromDescription() == userId)
				.map(LogEntity::getEventName)
				.collect(Collectors.toList());

		if (foundResults.size() > 0) {
			try {
				AlgoInputFileWriter algoInput = new AlgoInputFileWriter();
				algoInput.writeList(foundResults, LogData.getLogEvents());

				executeAlgorithms();

				AlgoOutputFileReader outputAlgo = new AlgoOutputFileReader();
				List<String> clusters = outputAlgo.getClusters(LogData.getLogEvents());
				for(String cluster : clusters) {
					System.out.println(cluster);
				}
				System.out.println();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			noDataFoundForSearchedUser(userId);
		}
	}*/
	
	private static void noDataFoundForSearchedUser(Integer userId) {
		System.out.println(StringConstants.NO_DATA_FOUND_FOR_USER_WITH_ID 
				+ userId + " !");
	}
	
	private static void executeAlgorithms() throws NumberFormatException, IOException {
		MainTestMultiDimSequentialPatternMiningClosed.main(null);
	}
}
