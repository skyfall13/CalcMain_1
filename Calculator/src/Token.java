
public class Token {

private String element;
private int state;
	
	public Token(String givenElement, int givenState){
		this.element = givenElement;
		this.state = givenState;
	}
	
	public int getState(){
		return this.state;
	}
	
	public String getElement(){
		return this.element;
	}
	
	public void setElement(String givenElement){
		this.element = givenElement;
	}
	
	
	public boolean isEmpty(){
		if (element.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isDigit(){
		try{
			Integer.parseInt(element);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}
	
}
