package com.restClient.restClientdemo;

public class NumberToWordsModel {
	private String numberFromInputField;
	private String numberToString;
	private Integer errorFlag;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getNumberFromInputField() {
		return numberFromInputField;
	}
	public void setNumberFromInputField(String numberFromInputField) {
		this.numberFromInputField = numberFromInputField;
	}
	
	public String getNumberToString() {
		return numberToString;
	}
	public void setNumberToString(String numberToString) {
		this.numberToString = numberToString;
	}
	
	public Integer getErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(Integer errorFlag) {
		this.errorFlag = errorFlag;
	}
	
}
