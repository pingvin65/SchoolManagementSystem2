package CoreJava.Models;

public class Course {
	protected int courseID;
	protected String courseName;
	protected double minimumGpa;

	/**
	 * 
	 * @param courseID is int course ID
	 * @param courseName is String course name
	 * @param minimumGpa is double minimum Gpa
	 */
	public Course(int courseID, String courseName, double minimumGpa) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.minimumGpa = minimumGpa;
	}

	/**
	 * 
	 */
	public Course() {

	}

	/**
	 * 
	 * @return int course ID
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
	 * @return String course Name
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 
	 * @param courseName is String, course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * 
	 * @return double  minimum Gpa
	 */
	public double getMinimumGpa() {
		return minimumGpa;
	}

	/**
	 * 
	 * @param minimumGpa is double
	 */
	public void setMinimumGpa(double minimumGpa) {
		this.minimumGpa = minimumGpa;
	}
}
