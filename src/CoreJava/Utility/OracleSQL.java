package CoreJava.Utility;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;
import CoreJava.Models.Student;
import CoreJava.Models.Teaching;
import CoreJava.Models.TeacingInstructor;

/**
 * 
 * @author pingvin
 * 
 */
public class OracleSQL extends DBConnection {

	private static Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps;

	/**
	 * 
	 * @param query is String SQL query
	 * @return ResultSet is public interface ResultSet
	 */
	public ResultSet getData(String query) {
		rs = null;
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(query);

			// stmt.close();
			// getConnection().close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeStmt();
		// closeConection();

		return rs;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return int generated Key
	 */
	public int insertData2(String query) {
		rs = null;
		int generatedKey = 0;
		try {
			ps = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.execute();
			ps = getConnection().prepareStatement("SELECT teaching_id from (\r\n"
					+ "    SELECT * FROM teaching ORDER BY TEACHING_ID DESC\r\n" + ") WHERE ROWNUM = 1");
			// PreparedStatement ps = getConnection().prepareStatement("SELECT
			// TEACHING_SEQ.nextval FROM dual");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return generatedKey;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return <code>List Attending </code>
	 */
	public List<Attending> getAttendings(String query) {
		List<Attending> attendings = new ArrayList<Attending>();

		rs = getData(query);
		try {
			while (rs.next())
				// SELECT attending_id, course_id, student_id FROM attending;
				// Attending(int attendinID, int courseID, int studentID)
				attendings.add(new Attending(rs.getInt("student_id"), rs.getInt("course_id"), rs.getInt("student_id")));

			// rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendings;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List Attending
	 */
	public List<Attending> insertAttendings(String query) {
		List<Attending> attendings = new ArrayList<Attending>();

		rs = getData(query);
		try {
			while (rs.next())
				// SELECT attending_id, course_id, student_id FROM attending;
				// Attending(int attendinID, int courseID, int studentID)
				attendings.add(new Attending(rs.getInt("student_id"), rs.getInt("course_id")));

			// rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendings;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Course
	 */
	public List<Course> getCourses(String query) {
		List<Course> courses = new ArrayList<Course>();

		rs = getData(query);
		try {
			while (rs.next()) // Course(int courseID, String courseName, double minimumGpa)
				courses.add(
						new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getDouble("minimun_gpa")));

			// rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return courses;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Instructor
	 */
	public List<Instructor> getInstructors(String query) {
		List<Instructor> instructors = new ArrayList<Instructor>();
		rs = null;
		rs = getData(query);
		try {
			while (rs.next())
				// Instructor(int instructorID, int adminRole, String fullName, String email,
				// String speciality, String pass)
				// SELECT instructor_id, admin_role, full_name, speciality, pass FROM
				// instructor;
				instructors.add(
						new Instructor(rs.getInt("instructor_id"), rs.getInt("admin_role"), rs.getNString("full_name"),
								rs.getNString("email"), rs.getNString("speciality"), rs.getNString("pass")));

			// rs.close();
			// closeStmt();
			// closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instructors;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Student
	 */
	public List<Student> getStudents(String query) {
		List<Student> students = new ArrayList<Student>();

		rs = getData(query);
		try {
			while (rs.next()) // Course(int courseID, String courseName, double minimumGpa)
				students.add(new Student(rs.getInt("student_id"), rs.getNString("full_name"), rs.getNString("email"),
						rs.getNString("pass"), rs.getFloat("gpa")));

			rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Teaching
	 */
	public List<Teaching> getTeachings(String query) {
		List<Teaching> teachings = new ArrayList<Teaching>();

		rs = getData(query);
		try {
			while (rs.next())
				// SELECT teaching_id, course_id,instructor_id FROM teaching;
				// Teaching(int teachingID, int courseID, int instructorID)
				teachings.add(
						/*
						 * SELECT course_name, full_name, email, minimun_gpa FROM teacinginstructors;
						 * new Teaching(rs.getInt("teaching_id"), rs.getInt("course_id"),
						 * rs.getInt("instructor_id"))); Teaching(String courseName, String fullName,
						 * String email, double minimumGpa)
						 */
						new Teaching(rs.getString("course_name"), rs.getString("full_name"), rs.getString("email"),
								rs.getDouble("minimun_gpa")));
			rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teachings;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Teaching
	 */
	public List<Teaching> getTeachingsInt(String query) {
		List<Teaching> teachings = new ArrayList<Teaching>();

		rs = getData(query);
		try {
			while (rs.next())
				teachings.add(

						new Teaching(rs.getInt("teaching_id"), rs.getInt("course_id"), rs.getInt("instructor_id")));

			rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teachings;
	}

	/**
	 * 
	 * @param query is String SQL query
	 * @return List of Teaching
	 */
	public List<Teaching> getTeacingInstructor(String query) {
		// View TeacingInstructor
		List<Teaching> teacingInstructors = new ArrayList<Teaching>();

		rs = getData(query);
		try {
			while (rs.next())
				// SELECT course_name, minimun_gpa, full_name, email FROM teacinginstructors;
				// TeacingInstructor(String courseName, String fullName, String email, double
				// minimumGpa)
				teacingInstructors.add(new Teaching(rs.getString("course_name"), rs.getString("full_name"),
						rs.getString("email"), rs.getDouble("minimun_gpa")));

			// rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacingInstructors;
	}

	/**
	 * @param query is String SQL query
	 * @return List of TeacingInstructor
	 */
	public List<TeacingInstructor> getTeacingInstructor2(String query) {
		// View TeacingInstructor
		List<TeacingInstructor> teacingInstructors = new ArrayList<TeacingInstructor>();

		rs = getData(query);
		try {
			while (rs.next())
				// SELECT course_name, minimun_gpa, full_name, email FROM teacinginstructors;
				// TeacingInstructor(String courseName, String fullName, String email, double
				// minimumGpa)
				teacingInstructors.add(new TeacingInstructor(rs.getString("course_name"), rs.getString("full_name"),
						rs.getString("email"), rs.getDouble("minimun_gpa")));

			// rs.close();
			closeStmt();
			closeConection();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacingInstructors;
	}

	/**
	 * close Conection
	 */
	public void closeConection() {
		try {
			if (!getConnection().isClosed() || getConnection() != null)
				getConnection().close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void closeStmt() {
		try {
			if (stmt != null || !stmt.equals(null) || !stmt.isClosed())
				stmt.close();
		} catch (SQLException | NullPointerException e) {
			//e.printStackTrace();
		}
	}

}
