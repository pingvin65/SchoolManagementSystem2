package CoreJava.DAO;

import java.sql.ResultSet;

import java.util.List;

import CoreJava.Models.Course;
import CoreJava.Utility.OracleSQL;
import CoreJava.systemsInterfaces.CourseDAOI;


public class CourseDAO implements CourseDAOI{
	OracleSQL concourses;
	ResultSet rs=null;
	
	/**
	 * return List
	 */
	@Override
	public List<Course> getAllCourses() {
		return new OracleSQL().getCourses("SELECT course_id, course_name, minimun_gpa FROM course");
	}

	/**
	 * return List
	 */
	@Override
	public List<Course> getCourseByInstructor(int courseID) {
		return new OracleSQL().getCourses(
				"SELECT * FROM course WHERE course_id IN (SELECT course_id FROM teaching WHERE instructor_id ="
						+ courseID + ")");
	}

}
