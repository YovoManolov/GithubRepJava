package seqDimSonigramApp;
public class SeqDim_Sonigram {

	public static void main(String[] args) {
		LogData.initializeLogData();
		MenuImpl menuImpl= new MenuImpl();
		menuImpl.startMenu();
	}
}