package CoreJava.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;
import CoreJava.Models.Teaching;
import CoreJava.Utility.OracleSQL;
import CoreJava.systemsInterfaces.AttendingDAOI;

/**
 * 
 */
public class AttendingDAO implements AttendingDAOI {

	@Override
	public int registerStudentToCourse(Student student, Course course) {
		int newCourse = -3;
		boolean isertData = false;
		//System.out.println(student.getGpa() + "     " + course.getMinimumGpa());
		try {
			if (student.getGpa() >= course.getMinimumGpa()) {
				List<Attending> stuNumCor = getStudentCourse1(student.getStudentID());
				if (stuNumCor.size() > 0) {
					for (Attending c : getStudentCourse1(student.getStudentID())) {
						//System.out.println("c.getCourseName()  " + c.getFullName() + "  course.getCourseName() "
						//		+ course.getCourseName());
						if (c.getCourseName().equals(course.getCourseName())) {
							System.out.println("Sorry, the course you are already attending.");
							isertData = false;
							//newCourse = -2;
							break;
						} else {
							isertData = true;
						}
					}
				} else {


					//newCourse = -5;
					isertData = true;
				}
			} else {
				//newCourse = -1;
				throw new StudentRegistrationException("Did not meet the minimum GPA requirement");

			}
		} catch (StudentRegistrationException e) {
			System.err.println(e.getMessage());
		}
		//System.out.println("newCourse  " + newCourse);

		try {
			if (isertData) {
				if (checkIfTeacherHasCourse(course.getCourseID()).size() > 0) {

					newCourse =  new OracleSQL().insertData2("INSERT INTO attending (course_id, student_id) VALUES ("
					 + course.getCourseID() +"," + student.getStudentID() + ")");
				} else {
					throw new StudentRegistrationException(
							"Please try later, there are no instructors for that course.");
				}
			}
		} catch (StudentRegistrationException e) {
			System.err.println(e.getMessage());
		}
		// if(checkIfTeacherHasCourse(course.getCourseID()).size()>0 && isertData)
		return newCourse;
	}

	@Override
	public List<Course> getStudentCourse(int studentID) {
		return new OracleSQL().getCourses(
				"SELECT * FROM attending WHERE course_id IN (SELECT course_id FROM attending WHERE student_id="
						+ studentID + ")");
	}

	@Override
	public List<Attending> getStudentCourse1(int studentID) {
		ResultSet rs = null;
		List<Attending> attendings = new ArrayList<Attending>();

		rs = new OracleSQL().getData(
				"SELECT (SELECT course_name FROM course WHERE course_id = attending.course_id) as course_name, "
						+ "(SELECT instructor.full_name FROM instructor WHERE instructor_id = teaching.instructor_id) as inst_full_name, "
						+ "(SELECT instructor.email FROM instructor WHERE instructor_id = teaching.instructor_id) as inst_email "
						+ "FROM attending INNER JOIN teaching ON teaching.course_id = attending.course_id "
						+ "INNER JOIN student ON attending.student_id = student.student_id WHERE attending.student_id ="
						+ studentID);
		try {
			while (rs.next()) { //
				attendings.add(new Attending(rs.getString("course_name"), rs.getString("inst_full_name"),
						rs.getString("inst_email")));
			}
			// rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendings;
	}

	public List<Teaching> checkIfTeacherHasCourse(int courseID) {
		return new OracleSQL().getTeachingsInt(
				"SELECT teaching.teaching_id, teaching.instructor_id, teaching.course_id FROM teaching WHERE course_id ="
						+ courseID);
	}
}
