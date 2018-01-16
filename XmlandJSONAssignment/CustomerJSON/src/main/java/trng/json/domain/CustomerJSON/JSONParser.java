package trng.json.domain.CustomerJSON;

import java.io.IOException;
import java.util.Scanner;

import static trng.json.domain.CustomerJSON.JSONParserUtil.*;

public class JSONParser {

	static String filePath = "R:\\JAVA_SW_12_18\\Customer1.json";
	public static void main(String[] args) throws IOException {
		do {
			menu();
			Scanner sc1 = new Scanner(System.in);
	    	int choices = sc1.nextInt();
	    	Choices userChoice = Choices.getChoice(choices);
	    	switch (userChoice) {
			case SERIALIZE:
				Serializer(filePath);
				break;
			case DESERIALIZETOOBJ:
				DeSerializer(filePath);
				break;
			case DESERIALIZETOMAP:
				DeSerializerToMap(filePath);
					break;
			case EXIT:
				System.exit(0);
				}
		} while (true);
	}

}
