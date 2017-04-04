package team13;
import java.util.Scanner;

public class Application {
	
	private Calculate calculate;
	
	public void run(String args){
		
		this.calculate = new Calculate();
		String input = args;
		int result;
		
		this.calculate.setParse(input);
		this.calculate.token2Postfix();
		result = this.calculate.evalPostfix();
		System.out.println(result);
		
	}

}
