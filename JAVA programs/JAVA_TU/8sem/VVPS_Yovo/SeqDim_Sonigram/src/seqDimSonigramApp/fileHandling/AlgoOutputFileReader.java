package seqDimSonigramApp.fileHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlgoOutputFileReader {

	private static final String OUTPUT_ALGOFILE_NAME = "output1.txt";
	private static final int CLOSING_SQUARE_BRACKET = ']';
	private static final int SPACE = ' ';

	public List<String> getClusters(List<String> listForMapping)
									  throws IOException {
		
		if(listForMapping == null || listForMapping.size() ==  0) {
			System.out.println("getClusters parameter is null or empty!\n");
			return new ArrayList<>();
		}
		// Process output file
		BufferedReader reader = new BufferedReader(
									new FileReader(OUTPUT_ALGOFILE_NAME));
		String line;
		long clusterLength;
		int clusterId;
		
		List<String> results = new ArrayList<String>();

		// Skip attribute
		line = reader.readLine();
		System.out.println("\nRESULTS FROM SEARCH");

		// read each cluster, count its elements
		//and get id for mapping of a cluster element
		while (((line = reader.readLine()) != null)) {
			clusterLength = line.codePoints().filter(ch -> ch == CLOSING_SQUARE_BRACKET).count();
			clusterId = parseClusterId(line);
			
			if (clusterId != -1) {
				results.add(new String("###" + listForMapping.get(clusterId) + "###" 
						+ " accessed " + clusterLength
						+ " times by the searched user."));		
			}
			
		}
		reader.close();
		return results;
	}
	
	//cluster format [instance1 2.0] [instance2 2.0]..
	public int parseClusterId(String cluster) {
		int indexBegin = cluster.indexOf(SPACE);
		int indexEnd = cluster.indexOf(CLOSING_SQUARE_BRACKET);
		if (indexBegin != -1 && indexEnd != -1 && indexBegin < indexEnd) {
			try {
				String clIdStr = cluster.substring(indexBegin + 1, indexEnd);
				int clusterId = (int) Double.parseDouble(clIdStr);
				return clusterId;		
			} catch (NumberFormatException e) {
				return -1;
			} catch (NullPointerException e) {
				return -1;
			}	
		}
		return -1;
	}
}