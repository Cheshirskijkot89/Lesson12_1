package chizhenko;

public class MyException extends Exception {

	private int arrayIndex;

	public MyException(int arrayIndex) {
		super();
		this.arrayIndex = arrayIndex;
	}

	@Override
	public String toString() {
		
		return "My exception [ wrong index: " + arrayIndex + "]";
	}
	
	
	
}
