package CoreJava.systemsInterfaces;

import java.util.List;

import CoreJava.Models.Course;

/**
 * 
 * @author pingvin
 *
 */
public interface CourseDAOI {

	/**
	 * 
	 * @return List  Object Course
	 */
	public List<Course> getAllCourses();

	/**
	 * 
	 * @param courseID is int
	 * @return List  Object Course
	 */
	public List<Course> getCourseByInstructor(int courseID);

}
