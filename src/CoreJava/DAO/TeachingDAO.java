package CoreJava.DAO;

import java.util.List;


import CoreJava.Models.Teaching;
import CoreJava.Utility.OracleSQL;
import CoreJava.systemsInterfaces.TeachingDAOI;

public class TeachingDAO implements TeachingDAOI {

	@Override
	public int assignInstructorToCourse(int courseID, int instructorID) {
		
		int n = -1;
		List<Teaching> list = new OracleSQL().getTeachingsInt("SELECT * FROM teaching WHERE course_id=" + courseID +" and instructor_id=" + instructorID);
				

		if (list.isEmpty()) {
			n = new OracleSQL().insertData2("INSERT INTO TEACHING (COURSE_ID, INSTRUCTOR_ID) VALUES ("+ courseID + ",  "+ instructorID +")");
			
		}
		return n;
	}

	@Override
	public List<Teaching> getIntructorsCourses() {
		return new OracleSQL().getTeachings(
				//"SELECT course.course_name, course.minimun_gpa ,instructor.full_name, instructor.email FROM teaching, course, instructor WHERE teaching.course_id = course.course_id");
				"SELECT course_name, minimun_gpa, full_name, email FROM teacinginstructors");
	}
	
	@Override
	public List<Teaching> getAllTeacingInstructors() {
		return new OracleSQL().getTeacingInstructor("SELECT course_name, minimun_gpa, full_name, email FROM teacinginstructors");
	}
	
	
}
