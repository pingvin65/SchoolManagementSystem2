package CoreJava.systemsInterfaces;

import java.util.List;

import CoreJava.Models.Teaching;

/**
 * 
 * @author pingvin
 *
 */
public interface TeachingDAOI {
	
	/**
	 * 
	 * @param courseID is int
	 * @param instructorID is int
	 * @return int
	 */
	public int assignInstructorToCourse(int courseID, int instructorID);
	
	
	/**
	 * 
	 * @return List  Teaching
	 */
	public List<Teaching> getIntructorsCourses();


	public List<Teaching> getAllTeacingInstructors();
}
