package com.Train1;

public enum Choices {
	DISPLAY, INSERT, FINDEMPBYID, FINDEMPBYNAME, DELETEEMPBYID, UPDATE, GROSSSALARYBYEMPID,
	SORTBYAGESALARY, SORTBYNAME, UNIQUENAMES, AGERANGE, EXIT,UNKOWN;
	public static Choices getChoice(int choiceNumber) {
	        for(Choices choice : Choices.values()) {
	            if(choice.ordinal() == choiceNumber) {
	                return choice;
	            }
	        }
	        return UNKOWN;
	    }
}
