package CoreJava.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import CoreJava.Models.Student;
import CoreJava.Utility.OracleSQL;
import CoreJava.systemsInterfaces.StudentDAOI;

public class StudentDAO implements StudentDAOI{
	Student student=null;
	ResultSet rs=null;
	OracleSQL emailStudent;
	String email;
	
	/**
	 * 
	 * @param email is String 
	 * @return Object Student 
	 */
	@Override
	public Student getStudentByEmail(String email) {

		emailStudent = new OracleSQL();

		try {
			rs = emailStudent.getData("SELECT * FROM sbudai.student WHERE email='"+ email + "'");
			while(rs.next()) 
			student = new Student(rs.getInt("student_id"), rs.getNString("full_name"), rs.getNString("email"), rs.getNString("pass"), rs.getFloat("gpa"));
			rs.close();
			emailStudent.closeStmt();
			emailStudent.closeConection();
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
		
	}
	
	/**
	 * 
	 * @param passToValidate is String
	 * @param comparablePas is String
	 * @return boolean
	 */
	public boolean validateUser(String passToValidate, String comparablePas) {

		return (passToValidate.equals(comparablePas)) ? true:false;
		
	}
	
	
	/**
	 * this method may not be required
	 * @param email isString
	 * @return String
	 */
	public String getPassStudents(String email) {
		return getStudentByEmail(email).getEmail();
		
	}


}
