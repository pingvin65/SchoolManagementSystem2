package CoreJava.Models;

public class Instructor {
	protected int instructorID, adminRole;
	protected String fullName, email, speciality, pass;

	/**
	 * 
	 * @param instructorID is int instructor ID
	 * @param adminRole is int admin role
	 * @param fullName is String full name
	 * @param email is String email
	 * @param speciality is String speciality
	 * @param pass is String pass
	 */
	public Instructor(int instructorID, int adminRole, String fullName, String email, String speciality, String pass) {
		super();
		this.instructorID = instructorID;
		this.adminRole = adminRole;
		this.fullName = fullName;
		this.email = email;
		this.speciality = speciality;
		this.pass = pass;
	}

	/**
	 * 
	 * @return int instructorID
	 */
	public int getInstructorID() {
		return instructorID;
	}

	/**
	 * 
	 * @param instructorID is int
	 */
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	/**
	 * 
	 * @return int adminRole
	 */
	public int getAdminRole() {
		return adminRole;
	}

	/**
	 * 
	 * @param adminRole is int 
	 */
	public void setAdminRole(int adminRole) {
		this.adminRole = adminRole;
	}

	/**
	 * 
	 * @return String full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 
	 * @param fullName is String full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email is String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * 
	 * @param speciality is String speciality
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 * 
	 * @return String pass (password)
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * 
	 * @param pass is String pass (password)
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

}
