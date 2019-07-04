package seqDimSonigramApp.dataModels;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import seqDimSonigramApp.fileHandling.LogFileReader;

/*this class is use*/
public class LogData {
	
	private static List<LogEntity> fullLogData;
	private static List<String> logComponents;  //stores distinct list of all components
	private static List<String> logEventNames;	//stores distinct list of all EventNames
	private static List<String> logEventContexts; //stores distinct list of all EventContexts
	private static List<String> logIPs; //stores distinct list of all IPs
	
	public static void initializeLogData() {
		LogData.fullLogData = LogFileReader.readToList();
		
		HashSet<String> componentSet = new HashSet<String>();
		HashSet<String> eventNameSet = new HashSet<String>();
		HashSet<String> eventContextSet = new HashSet<String>();
		HashSet<String> ipSet = new HashSet<String>();
		
		//store distinct elements only
		for (LogEntity log : fullLogData) {
			componentSet.add(log.getComponent());
			eventNameSet.add(log.getEventName());
			eventContextSet.add(log.getEventContext());
			ipSet.add(log.getIp());
		}
		
		LogData.logComponents = new ArrayList<String>(componentSet);
		LogData.logEventNames = new ArrayList<String>(eventNameSet);
		LogData.logEventContexts = new ArrayList<String>(eventContextSet);
		LogData.logIPs = new ArrayList<>(ipSet);
	}

	public static List<LogEntity> getFullLogData() {
		return fullLogData;
	}

	public static List<String> getLogComponents() {
		return logComponents;
	}

	public static List<String> getLogEventNames() {
		return logEventNames;
	}

	public static List<String> getLogEventContexts() {
		return logEventContexts;
	}
	
	public static List<String> getLogIPs() {
		return logIPs;
	}
	
	private LogData() {
	}

}
