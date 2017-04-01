import java.util.Scanner;


public class Application {

	private Calculate _calculate;
	
	public void evalExpression(){
		int finalValue;
		System.out.println("[Infix를 Postfix로]");
		if ( this._calculate.infixToPostfix()) {
			System.out.println("[Postfix] " + this._calculate.postfix());
			finalValue = this._calculate.evalPostfix();
			System.out.println("[최종값] "+ finalValue );
		}
		else
			System.out.println("[오류] 입력된 수식에 오류가 있습니다.");
	}
	
	public void run (){
		Scanner scan = new Scanner(System.in);
		String input;
		
		this._calculate = new Calculate();
		
		System.out.print("> 수식을 입력하시오: ");
		while(scan.hasNext()) {
			input = scan.nextLine();
			this._calculate.setInfix(input);
			this.evalExpression();
			System.out.print("> 수식을 입력하시오: ");
		}
	}
	
}
