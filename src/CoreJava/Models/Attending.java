package CoreJava.Models;

public class Attending {
	protected int attendinID, courseID, studentID;
	protected String courseName, fullName, email;

	/**
	 * all input data are is integer
	 * 
	 * @param attendinID is int 
	 * @param courseID is int
	 * @param studentID is int
	 */
	public Attending(int attendinID, int courseID, int studentID) {
		super();
		this.attendinID = attendinID;
		this.courseID = courseID;
		this.studentID = studentID;
	}

	/**
	 * all input data are is integer
	 * 
	 * @param courseID is int
	 * @param studentID is int
	 */
	public Attending(int courseID, int studentID) {
		super();
		this.courseID = courseID;
		this.studentID = studentID;
	}
	// att.getCourseName(), att.getFullName(), att.getEmail());
//	public Attending(String courseName, String fullName, String email) {
//		super();
//		Course c = new Course();
//		//c.setCourseName(courseName);
//		c.setCourseName(courseName);
//		Student s = new Student(fullName, email);
//		
//
//		this.fullName = s.getFullName();
//		this.email = s.getEmail();
//		
//		//this.courseName = new Course();
//	}

	/**
	 * all input data are is String
	 * 
	 * @param courseName is String
	 * @param fullName is String
	 * @param email is String
	 */
	public Attending(String courseName, String fullName, String email) {
		this.courseName = courseName;
		this.fullName = fullName;
		this.email = email;
	}

	/**
	 * 
	 * @return attendinID int
	 */
	public int getAttendinID() {
		return attendinID;
	}

	/**
	 * 
	 * @param attendinID is int
	 */ 
	public void setAttendinID(int attendinID) {
		this.attendinID = attendinID;
	}

	/**
	 * 
	 * @return courseID int
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * 
	 * @param courseID is int
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/**
	 * 
	 * @return studentID int
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * 
	 * @param studentID is int
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * fullName instructor
	 * @return String full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * instructor email
	 * @return String email 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * course Name
	 * @return String course name
	 */
	public String getCourseName() {
		return courseName;
	}

}
