package CoreJava.systemsInterfaces;

import java.util.List;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;
/**
 * 
 * @author pingvin
 *
 */
public interface AttendingDAOI {
	
	/**
	 * 
	 * @param student is Object
	 * @param course is Object
	 * @return int
	 */
	public int registerStudentToCourse(Student student, Course course);
	
	/**
	 * 
	 * @param studentID is int
	 * @return List Course"
	 */
	public List<Course> getStudentCourse(int studentID);
	
	public List<Attending> getStudentCourse1(int studentID);
}
