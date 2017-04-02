import java.util.Scanner;

public class Application {
	
	private Calculate calculate;
	
	public void run(){
		
		this.calculate = new Calculate();
		Scanner scan = new Scanner(System.in);
		String input;
		int result;
		
		System.out.print("> 수식을 입력하시오: ");
		while(scan.hasNext()) {
			input = scan.nextLine();
			this.calculate.setParse(input);
			this.calculate.token2Postfix();
			result = this.calculate.evalPostfix();
			System.out.println(result);
			System.out.print("> 수식을 입력하시오: ");
		}
	}
}
