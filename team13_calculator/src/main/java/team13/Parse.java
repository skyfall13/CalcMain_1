import java.util.ArrayList;

public class Parse {

	private ArrayList<Token> tokens;
	private int length;

	public Parse() {
		tokens = new ArrayList<Token>();
		length = 0;
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public void parsing(String givenString) {
		length = givenString.length();
		char tempChar;
		String tempString;
		int i = 0;

		while (i < length) {
			tempString = "";
			tempChar = givenString.charAt(i);
			if (tempChar == '+' || tempChar == '-' || tempChar == '*' || tempChar == '/'||tempChar == '('||tempChar == ')') {
				tempString += tempChar;
				i++;
			}
			while (tempChar >= '0' && tempChar <= '9') {
				tempString += tempChar;
				i++;
				if (i == length)
					break;
				tempChar = givenString.charAt(i);
				
			}
			tokens.add(new Token(tempString));
		}
	}
}
