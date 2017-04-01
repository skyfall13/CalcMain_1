public class ArrayStack<Element> {

	private static final int DEFAULT_MAX_STACK_SIZE = 10;
	private int _maxSize;
	private int _top;
	private Element[] _elements;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this._elements = (Element[])new Object[DEFAULT_MAX_STACK_SIZE];
		this._maxSize = DEFAULT_MAX_STACK_SIZE;
		this._top = -1;
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) {
		this._elements = (Element[])new Object[maxSize];
		this._maxSize = maxSize;
		this._top = -1;	
	}

	public boolean isEmpty() {
		return this._top == -1;
	}

	public boolean isFull() {
		return this._top == this._maxSize-1;
	}

	public int length() {
		return this._top+1; 
	}

	public boolean push(Element newElement) {
		if(this.isFull())
			return false;
		else {
			this._top++;
			this._elements[this._top] = newElement;
			return true;
		}
	}

	public Element pop() {
		if(this.isEmpty())
			return null;
		else{
			Element remove;
			remove =  this._elements[this._top];
			this._elements[this._top] = null;
			this._top--;
			return remove;
		}
	}

	public Element peek() {
		if(this.isEmpty())
			return null;
		else
			return this._elements[this._top];
	}

	public void clear() {
		this._elements = null;
		this._top = -1;
	}

	public Element findElementByOrder(int order) {
		return this._elements[order];
	}
}
