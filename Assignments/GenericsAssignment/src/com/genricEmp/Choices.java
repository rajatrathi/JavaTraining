package com.genricEmp;

public enum Choices {
	DISPLAY, INSERT, FINDEMP, DELETE, UPDATE,EXIT,UNKOWN;
	
	
	public static Choices getChoice(int choiceNumber) {
	        for(Choices choice : Choices.values()) {
	            if(choice.ordinal() == choiceNumber) {
	                return choice;
	            }
	        }
	        return UNKOWN;
	    }
}
