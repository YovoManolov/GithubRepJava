package seqDimSonigramApp;

import seqDimSonigramApp.dataModels.LogData;

public class SeqDim_Songram {

	public static void main(String[] args) {
		LogData.initializeLogData();
		MenuImpl menuImpl= new MenuImpl();
		menuImpl.startMenu();
	}
}