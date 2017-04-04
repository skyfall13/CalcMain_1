package team13;
import java.util.ArrayList;
import java.util.Stack;

public class Calculate {
	
	private Stack<Token> oStack;
	private Stack<Integer> vStack;
	private ArrayList<Token> tokens;
	private Parse parse;
	private Token[] postfix;
	
	public Calculate(){
		Stack<Character> oStack = null;
		Stack<Integer> vStack = null;
		ArrayList<Token> tokens = null;
		Parse parse = null;
	}

	public void setParse(String input) {
		this.parse = new Parse();
		this.tokens = new ArrayList<Token>();
		parse.parsing(input);
		this.tokens = parse.getTokens();
		
	}
	
	public boolean token2Postfix() {
		int i = 0;
		int p = 0;
		Token curToken, poppedToken, topToken;
		this.oStack = new Stack<Token>();
		this.postfix = new Token[this.tokens.size()];

		while (i < this.tokens.size()) {
			curToken = this.tokens.get(i++);
			if (curToken.isDigit())
				this.postfix[p++] = curToken;
			else {
				if (curToken.getElement().charAt(0) == ')') {
					if (!this.oStack.isEmpty())
						poppedToken = (Token) this.oStack.pop();
					else
						return false;

					while (poppedToken.getElement().charAt(0) != '(') {
						this.postfix[p++] = poppedToken;
						if (!this.oStack.isEmpty())
							poppedToken = (Token) this.oStack.pop();
						else
							return false;
					}
				} else {
					int inComingP = inComingPrecedence(curToken);
					if (!this.oStack.isEmpty()) {
						topToken = (Token) this.oStack.peek();
						while (inStackPrecedence(topToken) >= inComingP) {
							poppedToken = (Token) this.oStack.pop();
							this.postfix[p++] = poppedToken;
							if (!this.oStack.isEmpty())
								topToken = (Token) this.oStack.peek();
							else
								break;
						}
					}
					this.oStack.push(curToken);
				}
			}
		}
		while(!this.oStack.isEmpty()){
			poppedToken = (Token) this.oStack.pop();
			this.postfix[p++] = poppedToken;
		}
		return true;
	}
	
	public int evalPostfix() {
		int p = 0;
		Token curToken;
		int popToken1, popToken2, result;
		this.vStack = new Stack<Integer>();
		
		while(p < this.postfix.length && this.postfix[p] != null) {
			curToken = this.postfix[p++];
			if(curToken.isDigit()){
				this.vStack.push(Integer.parseInt(String.valueOf(curToken.getElement()))); 
				// char -> int (char ���� toString�Ұ�)
			}
			else{
				popToken2 = this.vStack.pop();
				popToken1 = this.vStack.pop();
				if(curToken.getElement().charAt(0) == '+'){
					this.vStack.push(popToken1 + popToken2);
				}
				else if(curToken.getElement().charAt(0) == '-'){
					this.vStack.push(popToken1 - popToken2);
				}
				else if(curToken.getElement().charAt(0) == '*'){
					this.vStack.push(popToken1 * popToken2);
				}
				else if(curToken.getElement().charAt(0) == '/'){
					this.vStack.push(popToken1 / popToken2);
				}
			}
		}
		result = this.vStack.pop();
		return result;
	}

	private int inComingPrecedence(Token givenToken) {
		if (givenToken.getElement().charAt(0) == '+' || givenToken.getElement().charAt(0) == '-')
			return 12;
		else if (givenToken.getElement().charAt(0) == '*' || givenToken.getElement().charAt(0) == '/')
			return 13;
		else if (givenToken.getElement().charAt(0) == '(')
			return 20;
		else if (givenToken.getElement().charAt(0) == ')')
			return 19;
		else
			return 0;
	}

	private int inStackPrecedence(Token givenToken) {
		if (givenToken.getElement().charAt(0) == '+' || givenToken.getElement().charAt(0) == '-')
			return 12;
		else if (givenToken.getElement().charAt(0) == '*' || givenToken.getElement().charAt(0) == '/')
			return 13;
		else if (givenToken.getElement().charAt(0) == '(')
			return 0;
		else if (givenToken.getElement().charAt(0) == ')')
			return 19;
		else
			return 0;
	}
	
}
