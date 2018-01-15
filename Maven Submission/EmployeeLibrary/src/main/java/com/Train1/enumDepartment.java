package com.Train1;

public enum enumDepartment  {

	SALES (10),	PURCHASE (20),	ADMINISTRATION(30),	RESEARCH (40),NO_SUCH_DEPT(-1);
	
	int value;
	
	private enumDepartment(int value)
	{
	this.value = value;
	
	}
	
	public static enumDepartment getType(int val) {
		  
		for(enumDepartment eObj : enumDepartment.values()) {
		      if(eObj.value == val) {
		         return eObj;
		      }
		     
		   }
		return NO_SUCH_DEPT;
		  
		}
}
