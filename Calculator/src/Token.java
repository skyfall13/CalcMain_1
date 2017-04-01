
public class Token {

private String element;
	
	public Token(String givenElement){
		this.element = givenElement;
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
