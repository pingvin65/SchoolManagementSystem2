package CoreJava.systemsInterfaces;

import java.util.List;

import CoreJava.Models.Instructor;

/**
 * 
 * @author pingvin
 *
 */
public interface InstructorDAOI {
	
	/**
	 * 
	 * @return Object Instructor
	 */
	public List<Instructor> getAllInstructors();
	
	/**
	 * 
	 * @param email is String
	 * @return Object Instructor
	 */
	public Instructor getInstructoByEmail(String email);
}
