package seqDimSonigramApp.dataModels;

import seqDimSonigramApp.utils.Constants;

public class MdPatternChoices {
	
	public static int SIZE_OF_MDS = 4; //multi-dimensional sequences
	
	private int[] choices ;
	private MDPatternType type;
	
	public MdPatternChoices(MDPatternType type) {
		super();
		this.choices = new int[Constants.SIZE_OF_MDS];
		this.type = type;
	}
	
	public int getChoiceAtIndex(int i) {
		return choices[i];
	}
	
	public int setChoiceAtIndex(int i,int value) {
		return choices[i] = value;
	}
	
	public int[] getChoices() {
		return choices;
	}

	public void setChoices(int[] choices) {
		this.choices = choices;
	}

	public MDPatternType getType() {
		return type;
	}
	public void setType(MDPatternType type) {
		this.type = type;
	}
	
}
