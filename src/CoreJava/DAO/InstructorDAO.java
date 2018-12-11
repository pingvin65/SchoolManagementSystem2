package CoreJava.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Instructor;
import CoreJava.Utility.OracleSQL;
import CoreJava.systemsInterfaces.InstructorDAOI;

public class InstructorDAO implements InstructorDAOI {

	private String[] instRouls = { "Instructor", "Admin", "Wrong Credentials" };
	private List<Instructor> listInstructors;

	@Override
	public List<Instructor> getAllInstructors() {
		listInstructors = new ArrayList<Instructor>();

		OracleSQL getlInstructors = new OracleSQL();
		ResultSet rs = getlInstructors
				.getData("select instructor_id, full_name, email, speciality, admin_role, pass FROM instructor");
		try {

			while (rs.next()) {
				listInstructors.add(
						new Instructor(rs.getInt("instructor_id"), rs.getInt("admin_role"), rs.getString("full_name"),
								rs.getString("email"), rs.getString("speciality"), rs.getString("pass")));
			}
			// rs.close();
			getlInstructors.closeStmt();
			getlInstructors.closeConection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listInstructors;
//		return new OracleConnection().getInstructors("select instructor_id, full_name, email, speciality, admin_role, pass FROM instructor");
	}

	/**
	 * @param email is String
	 * @return Object Instructor
	 */
	@Override
	public Instructor getInstructoByEmail(String email) {
		Instructor rin = null;
		for (Instructor in : getAllInstructors()) {
			if (email.equals(in.getEmail())) {
				in.getEmail();
				rin = in;
				break;
			}
		}
		return rin;
	}

	/**
	 * 
	 * @param email is String
	 * @return Object Instructor
	 * 
	 * 		no used
	 */
	public Instructor getInstructoByEmail2(String email) {
	

		return (Instructor) new OracleSQL().getInstructors(
				"select instructor_id, full_name, email, speciality, admin_role, pass FROM instructor  WHERE email='"
						+ email + "'");
	}

	/**
	 * 
	 * @param ins is Object Instructor
	 * @param comparablePas is String
	 * @return String
	 */
	public String validateUser(Instructor ins, String comparablePas) {
	
		String[] ansArray = getInstructorRouls(); // {"Instructor", "Admin", "Wrong Credentials"} ;
		String ans = ansArray[2];
		if (ins.getPass().equals(comparablePas)) {
			if (ins.getAdminRole() == 0) {
				ans = ansArray[0];
			} else if (ins.getAdminRole() == 1) {
				ans = ansArray[1];
			} else {
				ans = ansArray[2];
			}
		} else {
			ans = ansArray[2];
		}
		return ans;

	}

	/**
	 * 
	 * @return String array
	 */ 
	public String[] getInstructorRouls() {
		return instRouls;
	}
}
