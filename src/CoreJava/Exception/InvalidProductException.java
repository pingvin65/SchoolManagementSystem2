package CoreJava.Exception;

public class InvalidProductException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductException(String s) {
		// Call constructor of parent Exception
		super(s);
	}
}
