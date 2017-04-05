import java.util.ArrayList;


public class Parse {
	
	public static int INTEGER = 1;
	public static int PLUS = 2;
	public static int MINUS = 3;
	public static int MULTIPLY = 4;
	public static int DIVISION = 5;
	public static int OPEN_PARENTHESIS= 6;
	public static int CLOSE_PARENTHESIS = 7;

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
		int currentState;
		int i = 0;

		while (i < length) {
			currentState = 0;
			tempString = "";
			tempChar = givenString.charAt(i);
			// if (tempChar == '+' || tempChar == '-' || tempChar == '*' ||
			// tempChar == '/'||tempChar == '('||tempChar == ')') {
			// tempString += tempChar;
			// currentState = 2; 
			// i++;
			// }
			if (!(tempChar >= '0' && tempChar <= '9')) {
				tempString += tempChar;
				i++;
				switch (tempChar) {
				case '+':
					currentState = PLUS;
					break;
				case '-':
					currentState = MINUS;
					break;
				case '*':
					currentState = MULTIPLY;
					break;
				case '/':
					currentState = DIVISION;
					break;
				case '(':
					currentState = OPEN_PARENTHESIS;
					break;
				case ')':
					currentState = CLOSE_PARENTHESIS;
					break;
				}
			}
			while (tempChar >= '0' && tempChar <= '9') {
				tempString += tempChar;
				currentState = INTEGER; // state = 1 : integer
				i++;
				if (i == length)
					break;
				tempChar = givenString.charAt(i);

			}
			tokens.add(new Token(tempString, currentState));
		}
	}
}
