package CoreJava.CustomExceptions;

/**
 * 
 * @author pingvin
 * Custom Exceptions;
 *
 */
public class StudentRegistrationException extends Exception{


	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param e is String 
	 */
	public StudentRegistrationException(String e) {
		super(e);
	}

}
