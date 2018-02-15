package serverSide;

public class Grade {

	private int offertID;
	private boolean evaluation;
	
	public Grade(int offertID,boolean evaluation) {
		this.offertID = offertID;
		this.evaluation = evaluation;
	}
	
	public int getOffertID() {
		return offertID;
	}
	public void setOffertID(int offertID) {
		this.offertID = offertID;
	}
	public boolean isEvaluation() {
		return evaluation;
	}
	public void setEvaluation(boolean evaluation) {
		this.evaluation = evaluation;
	}
}
