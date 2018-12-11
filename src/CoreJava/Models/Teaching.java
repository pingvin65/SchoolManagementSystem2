package CoreJava.Models;

public class Teaching {

	private int teachingID, courseID, instructorID;

	protected String courseName, fullName, email;
	protected double minimumGpa;

	/**
	 * 
	 * @param teachingID is int teaching ID
	 * @param courseID is int course ID
	 * @param instructorID is int instructor ID
	 */
	public Teaching(int teachingID, int courseID, int instructorID) {
		super();
		this.teachingID = teachingID;
		this.courseID = courseID;
		this.instructorID = instructorID;
	}

	/**
	 * 
	 * @param courseName is String course name
	 * @param fullName String full name
	 * @param email is String email
	 * @param minimumGpa is double minimum Gpa
	 */
	public Teaching(String courseName, String fullName, String email, double minimumGpa) {
		super();
		this.courseName = courseName;
		this.fullName = fullName;
		this.email = email;
		this.minimumGpa = minimumGpa;
	}

	/**
	 * 
	 * @return int teaching ID
	 */
	public int getTeachingID() {
		return teachingID;
	}

	/**
	 * 
	 * @param teachingID is int teaching ID
	 */
	public void setTeachingID(int teachingID) {
		this.teachingID = teachingID;
	}

	/**
	 * 
	 * @return int teaching ID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * 
	 * @param courseID is int course ID
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/**
	 * 
	 * @return int course ID
	 */
	public int getInstructorID() {
		return instructorID;
	}

	/**
	 * 
	 * @param instructorID is int instructor ID
	 */
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	/**
	 * 
	 * @return String course name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 
	 * @param courseName is String course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * 
	 * @return string full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 
	 * @param fullName is String of full name 
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
	 * @return double of minimum gpa
	 */
	public double getMinimumGpa() {
		return minimumGpa;
	}

	/**
	 * 
	 * @param minimumGpa is double minimum Gpa
	 */
	public void setMinimumGpa(double minimumGpa) {
		this.minimumGpa = minimumGpa;
	}

}
