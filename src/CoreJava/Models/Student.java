package CoreJava.Models;

import java.text.DecimalFormat;

/**
 * @author pingvin
 *
 */
public class Student {

	protected int studentID;
	protected String fullName, email, pass;
	protected double gpa;
	protected final int studentRole = -1;

	/**
	 * 
	 * @param studentID is int student ID
	 * @param fullName  is String full name
	 * @param email     is String email
	 * @param pass      is String pass
	 * @param gpa       is ing gpa
	 */
	public Student(int studentID, String fullName, String email, String pass, double gpa) {
		super();
		this.studentID = studentID;
		this.fullName = fullName;
		this.email = email;
		this.pass = pass;
		this.gpa = gpa;
	}

	/**
	 * 
	 * @param fullName is String email
	 * @param email    is String full name
	 */
	public Student(String fullName, String email) {
		this.fullName = fullName;
		this.email = email;
	}

	/**
	 * 
	 * @return int student ID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * 
	 * @param studentID is int of student ID
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
	 * @return String pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * 
	 * @param pass is String pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 
	 * @return double Gpa
	 */
	public double getGpa() {
		DecimalFormat df2 = new DecimalFormat(".##");
		return Double.valueOf(df2.format(gpa));
	}

	/**
	 * 
	 * @param gpa is nameber double of gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * 
	 * @return int studen Role
	 */
	public int getStudentRole() {
		return studentRole;
	}

}
