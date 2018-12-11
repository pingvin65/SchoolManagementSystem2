package CoreJava.DAO;

import java.util.List;

import CoreJava.Models.TeacingInstructor;
import CoreJava.systemsInterfaces.TeacingInstructorsDAOI;

public class TeacingInstructorsDAO implements TeacingInstructorsDAOI{

	@Override
	public List<TeacingInstructor> getAllTeacingInstructors() {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public List<TeacingInstructor> getAllTeacingInstructors() {
//		return new OracleSQL().getTeacingInstructor("SELECT course_name, minimun_gpa, full_name, email FROM teacinginstructors");
//	}

}
