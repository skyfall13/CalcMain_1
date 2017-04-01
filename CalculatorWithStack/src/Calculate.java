public class Calculate {

	private ArrayStack<Character> _oStack;
	private ArrayStack<Integer> _vStack;
	private char[] _infix;
	private char[] _postfix;

	public Calculate() {
		this._oStack = null;
		this._vStack = null;
		this._infix = null;
		this._postfix = null;
	}

	public void setInfix(String givenInfix) {
		this._infix = givenInfix.toCharArray();
	}

	public String infix() {
		return String.valueOf(this._infix);
	}

	public String postfix() {
		return String.valueOf(this._postfix);
	}

	public boolean infixToPostfix() {
		int i = 0;
		int p = 0;
		char curToken, poppedToken, topToken;
		this._oStack = new ArrayStack<Character>();
		this._postfix = new char[this._infix.length];

		while (i < this._infix.length) {
			curToken = this._infix[i++];
			if (isdigit(curToken))
				this._postfix[p++] = curToken;
			else {
				if (curToken == ')') {
					if (!this._oStack.isEmpty())
						poppedToken = (char) this._oStack.pop();
					else
						return false;

					while (poppedToken != '(') {
						this._postfix[p++] = poppedToken;
						if (!this._oStack.isEmpty())
							poppedToken = (char) this._oStack.pop();
						else
							return false;
					}
					this.showOStackAll();
				} else {
					int inComingP = inComingPrecedence(curToken);
					if (!this._oStack.isEmpty()) {
						topToken = (char) this._oStack.peek();
						while (inStackPrecedence(topToken) >= inComingP) {
							poppedToken = (char) this._oStack.pop();
							this._postfix[p++] = poppedToken;
							if (!this._oStack.isEmpty())
								topToken = (char) this._oStack.peek();
							else
								break;
						}
					}
					this._oStack.push(curToken);
					this.showOStackAll();
				}
			}
		}
		while(!this._oStack.isEmpty()){
			poppedToken = (char) this._oStack.pop();
			this._postfix[p++] = poppedToken;
		}
		return true;
	}

	public int evalPostfix() {
		int p = 0;
		char curToken;
		int popToken1, popToken2, result;
		this._vStack = new ArrayStack<Integer>();
		
		while(p < this._postfix.length && this._postfix[p] != '\0') {
			curToken = this._postfix[p++];
			if(isdigit(curToken)){
				this._vStack.push(Integer.parseInt(String.valueOf(curToken))); 
				this.showVStackAll();
				// char -> int (char 형은 toString불가)
			}
			else{
				popToken2 = this._vStack.pop();
				popToken1 = this._vStack.pop();
				if(curToken == '+'){
					this._vStack.push(popToken1 + popToken2);
					this.showVStackAll();
				}
				else if(curToken == '-'){
					this._vStack.push(popToken1 - popToken2);
					this.showVStackAll();
				}
				else if(curToken == '*'){
					this._vStack.push(popToken1 * popToken2);
					this.showVStackAll();
				}
				else if(curToken == '/'){
					this._vStack.push(popToken1 / popToken2);
					this.showVStackAll();
				}
				
				else if(curToken == '%'){
					this._vStack.push(popToken1 % popToken2);
					this.showVStackAll();
				}
				
				else if(curToken == '^'){
					int popToken = 1;
					for(int i = 0; i < popToken2; i++)
						popToken *= popToken1;
					this._vStack.push(popToken);
					this.showVStackAll();
				}		
			}
		}
		result = this._vStack.pop();
		return result;
	}

	public void showOStackAll() {
		System.out.print(": ");
		for(int i = 0; i<this._oStack.length();i++)
			System.out.print(this._oStack.findElementByOrder(i)+ " ");
		
			System.out.println();
	}

	public void showVStackAll() {
		System.out.print(": ");
		for(int i = 0; i<this._vStack.length();i++)
			System.out.print(this._vStack.findElementByOrder(i)+ " ");
			System.out.println();
	}

	private boolean isdigit(char givenToken) {
		if (givenToken >= '0' && givenToken <= '9')
			return true;
		else
			return false;
	}

	private int inComingPrecedence(char givenToken) {
		if (givenToken == '+' || givenToken == '-')
			return 12;
		else if (givenToken == '*' || givenToken == '/' || givenToken == '%')
			return 13;
		else if (givenToken == '^')
			return 17;
		else if (givenToken == '(')
			return 20;
		else if (givenToken == ')')
			return 19;
		else
			return 0;
	}

	private int inStackPrecedence(char givenToken) {
		if (givenToken == '+' || givenToken == '-')
			return 12;
		else if (givenToken == '*' || givenToken == '/' || givenToken == '%')
			return 13;
		else if (givenToken == '^')
			return 16;
		else if (givenToken == '(')
			return 0;
		else if (givenToken == ')')
			return 19;
		else
			return 0;
	}

}
