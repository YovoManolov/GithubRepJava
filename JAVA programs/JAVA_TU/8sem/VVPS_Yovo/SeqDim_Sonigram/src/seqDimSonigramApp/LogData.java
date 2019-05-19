package seqDimSonigramApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class LogData {
	private static List<LogEntity> fullLogData;
	private static List<String> logComponents;
	private static List<String> logEvents;
	private static List<String> logEventContexts;

	public static void initializeLogData() {
		LogData.fullLogData = LogFileReader.readToList();
		
		HashSet<String> componentSet = new HashSet<String>();
		HashSet<String> eventSet = new HashSet<String>();
		HashSet<String> eventContextSet = new HashSet<String>();
		
		//store distinct elements only
		for (LogEntity log : fullLogData) {
			componentSet.add(log.getComponent());
			eventSet.add(log.getEventName());
			eventContextSet.add(log.getEventContext());
		}
		
		LogData.logComponents = new ArrayList<String>(componentSet);
		LogData.logEvents = new ArrayList<String>(eventSet);
		LogData.logEventContexts = new ArrayList<String>(eventContextSet);
	}

	public static List<LogEntity> getFullLogData() {
		return fullLogData;
	}

	public static List<String> getLogComponents() {
		return logComponents;
	}

	public static List<String> getLogEvents() {
		return logEvents;
	}

	public static List<String> getLogEventContexts() {
		return logEventContexts;
	}
	
	private LogData() {
	}

}
