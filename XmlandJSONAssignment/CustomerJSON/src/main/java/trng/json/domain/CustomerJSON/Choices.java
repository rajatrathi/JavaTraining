package trng.json.domain.CustomerJSON;

public enum Choices {
	SERIALIZE, DESERIALIZETOOBJ, DESERIALIZETOMAP,EXIT,UNKOWN;
	public static Choices getChoice(int choiceNumber) {
	        for(Choices choice : Choices.values()) {
	            if(choice.ordinal() == choiceNumber) {
	                return choice;
	            }
	        }
	        return UNKOWN;
	    }
}
