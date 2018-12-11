package CoreJava.Models;

/**
 * for view TEACINGINSTRUCTORS in  DB 
 * @author pingvin
 *
 */
public class TeacingInstructor {
	protected String courseName, fullName, email;
	protected double minimumGpa;

	public TeacingInstructor(String courseName, String fullName, String email, double minimumGpa) {
		super();
		this.courseName = courseName;
		this.fullName = fullName;
		this.email = email;
		this.minimumGpa = minimumGpa;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMinimumGpa() {
		return minimumGpa;
	}

	public void setMinimumGpa(double minimumGpa) {
		this.minimumGpa = minimumGpa;
	}

}
