package CoreJava.systemsInterfaces;

import CoreJava.Models.Student;

/**
 * 
 * @author pingvin
 *
 */
public interface StudentDAOI {
	
	/**
	 * 
	 * @param email isString
	 * @return Object Student
	 */
	public Student getStudentByEmail(String email);
}
