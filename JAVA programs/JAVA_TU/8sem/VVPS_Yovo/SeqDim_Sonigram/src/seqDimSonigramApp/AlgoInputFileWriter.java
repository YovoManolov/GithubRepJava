package seqDimSonigramApp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMining;
import ca.pfv.spmf.test.MainTestMultiDimSequentialPatternMiningClosed;
import ca.pfv.spmf.test.MainTestOPTICS_extractClusterOrdering_saveToFile;

public class AlgoInputFileWriter {

	private static final String INPUT_ALGOFILE_NAME = "ContextMDSequenceNoTime.txt";

	public boolean writeList(List<String> foundMatchesforUserId, List<String> listForMapping)
									throws IOException {
		
		if(listForMapping == null || listForMapping.isEmpty()
				|| foundMatchesforUserId == null || foundMatchesforUserId.isEmpty()) {
			System.out.println("writeList's parameter is null or empty!\n");
			return false;
		}
		
		Integer index;
		String outputFilePath = MainTestMultiDimSequentialPatternMiningClosed
								.fileToPath(INPUT_ALGOFILE_NAME);	
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
		
		for (String s : foundMatchesforUserId) {
			index = listForMapping.indexOf(s);
			writer.write(index.toString());
			writer.newLine();
		}
		writer.close();
		return true;
	}
}
