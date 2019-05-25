package seqDimSonigramApp.fileHandling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMining;
import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMiningClosed;
import ca.pfv.spmf.test.MainTestOPTICS_extractClusterOrdering_saveToFile;
import seqDimSonigramApp.dataModels.LogEntity;

public class AlgoInputFileWriter {

	private static final String INPUT_ALGOFILE_NAME = "ContextMDSequenceNoTime.txt";

	public boolean writeList(ArrayList<List<LogEntity>> findResultsForEachRow)
									throws IOException {
		Integer index;
		String outputFilePath = MainTestMultiDimSequentialPatternMiningClosed
								.fileToPath(INPUT_ALGOFILE_NAME);	
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
		
		//writing singleLine in input file
		
		for (List<LogEntity> logEntities : findResultsForEachRow) {
			
			//those values are the same for each List<LogEntity>
			String eventContext = logEntities.get(0).getEventContext();
			String component = logEntities.get(0).getComponent();
			String eventName = logEntities.get(0).getEventName();
			if(logEntities.isEmpty()) {
				System.out.println("writeList's parameter is null or empty!\n");
				return false;
			}
			/*index = listForMapping.indexOf(logEntity);*/
			String singleLineToWrite = ""+eventContext+" "+component+ " "+eventName+" -3 " ;
			for(LogEntity le:logEntities) {
				singleLineToWrite += (le.getIp()+" -1 ") ;
			}
			singleLineToWrite.substring(0, singleLineToWrite.length()-5);		
			writer.write(singleLineToWrite);
			writer.newLine();
		}
		writer.close();
		return true;
	}
}
