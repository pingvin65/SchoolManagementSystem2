/**
 * 
 */
package CoreJava.MainEntryPoint;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import CoreJava.DAO.InstructorDAO;
import CoreJava.DAO.TeacingInstructorsDAO;
import CoreJava.Exception.InvalidProductException;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;

import CoreJava.Models.TeacingInstructor;
import CoreJava.Utility.OracleSQL;

/**
 * @author pingvin
 *
 */
public class MainEntryTestClass {
	static Scanner sc = new Scanner(System.in);
	static OracleSQL con;

	/**
	 * @param args String array
	 */
	public static void main(String[] args) {
		// new InstructorDAO().getAllInstructors();
		try {
			userChoce(menuStart());
		} catch (NullPointerException ex) {
			System.err.println("Wrong Credentials");
			closeApp();
		}

	}

	/**
	 * 
	 * @return int number with user choice
	 */
	public static int menuStart() {
		int r = 0;
		System.out.print("Are you a(n):\n\t1. Instructor\n\t2. Student\n\t3. quit\nPlease, enter 1, 2 or 3\n-->");
		// sc = new Scanner(System.in);
		sc.reset();
		try {
			r = sc.nextInt();

			if (r < 1 || r > 3) {

				throw new InvalidProductException("No number with your choice -->  " + r + "\nPlease, enter 1, 2 or 3");
			}
		} catch (InputMismatchException e) {
			System.err.println("Please number, enter 1, 2 or 3");
		} catch (InvalidProductException ex) {

			System.err.println(ex.getMessage());
		}
		// sc.close();
		return r;
	}

	/**
	 * 
	 * @param c is int
	 * @return int c
	 */
	public static int userChoce(int c) {
		switch (c) {
		case 1:
			try {
				instructorUser();
			} catch (SQLSyntaxErrorException e) {
				System.err.println("System error, please contact Administrator");
				closeApp();
			}
			break;
		case 2:
			System.out.println("ffff");
			InstructorDAO insD = new InstructorDAO();
			insD.getAllInstructors();

			break;
		default:
			closeApp();
		}
		return c;

	}

	/**
	 * 
	 * @throws SQLSyntaxErrorException is Exception
	 */
	public static void instructorUser() throws SQLSyntaxErrorException {
		String email, pass;
		// sc = new Scanner(System.in);
		System.out.print("\n\nEnter Your Email:\n>");
		email = sc.next();
		sc.reset();
		System.out.print("\nEnter Your Password:\n>");
		pass = sc.next();
		// sc.close();
		InstructorDAO insD = new InstructorDAO();
		Instructor ins = insD.getInstructoByEmail(email);

		String instruValid = insD.validateUser(ins, pass);
		if (instruValid.equals(insD.getInstructorRouls()[2])) {

			try {
				throw new InvalidProductException("Wrong Credentials");
			} catch (InvalidProductException ex) {
				System.err.println(ex.getMessage());
				closeApp();
			}
		} else if (instruValid.equals(insD.getInstructorRouls()[1])) {
			System.out.println("sssss");
			instructorsCourses(new TeacingInstructorsDAO().getAllTeacingInstructors());
			//////
			instructorManager(ins);

		} else {
			// con = new OracleConnection();
			List<Course> course = con.getCourses(
					"SELECT course.course_id ,course.course_name, course.minimun_gpa FROM teaching, course WHERE teaching.instructor_id="
							+ ins.getInstructorID() + " and teaching.course_id = course.course_id");
			if (course.isEmpty()) {
				System.out.println("No Course");
			} else {
				instructorCourses(course);
			}
		}
	}

	/**
	 * 
	 * @param course is List Course
	 */
	public static void instructorCourses(List<Course> course) {
		System.out.printf("%-30s|%-20s|\n", "COURSE NAME", "COURSE MINIMUN GPA");
		System.out.printf("%-30s|%-20s|\n", printChars('-', 30), printChars('-', 20));
		for (Course c : course) {
			System.out.printf("%-30s|%20s|\n", c.getCourseName(), c.getMinimumGpa());
		}
		System.out.print("\t1. Logout\n>");
		try {
			sc.reset();
			// sc.nextInt();
			if (sc.nextInt() != 1) {
				throw new InvalidProductException("");
			} else {
				try {
					userChoce(menuStart());
				} catch (NullPointerException ex) {
					System.err.println("Wrong Credentials");
					closeApp();
				}
			}
		} catch (InvalidProductException ex) {
			System.err.println("The wrong choice");
			closeApp();
		} catch (InputMismatchException ex) {
			System.err.println("The wrong choice");
			closeApp();
		}

		// menuStart();
	}

	/**
	 * 
	 * @param tc is List TeacingInstructor
	 */
	public static void instructorsCourses(List<TeacingInstructor> tc) {
		// COURSE NAME COURSE MINIMUN GPA INTRUCTOR NAME INSTRUCTOR EMAIL
		System.out.printf("%-20s|%-20s|%-20s|%-20s|\n", "COURSE NAME", "COURSE MINIMUN GPA", "INTRUCTOR NAME",
				"INSTRUCTOR EMAIL");
		System.out.printf("%-20s|%-20s|%-20s|%-20s|\n", printChars('-', 20), printChars('-', 20), printChars('-', 20),
				printChars('-', 20));
		for (TeacingInstructor t : tc) {
			System.out.printf("%-20s|%20.1f|%-20s|%-20s|\n", t.getCourseName(), t.getMinimumGpa(), t.getFullName(),
					t.getEmail());
		}
	}

	/**
	 * 
	 * @param ca     is char
	 * @param repite is int
	 * @return String
	 */
	public static String printChars(char ca, int repite) {
		String s = "";
		for (int i = 0; i < repite; i++) {
			s += ca;

		}
		return s;

	}

	/**
	 * 
	 * @param ins is Object Instructor
	 */
	public static void instructorManager(Instructor ins) {
		int userChoice;
		System.out.println("\n1. Assign Instructor to Course\r\n2. Logout\r\n>");
		try {
			if ((userChoice = sc.nextInt()) == 2) {
				closeApp();
			} else if (userChoice != 1) {
				throw new InvalidProductException("a non-existent choice");
			}
		} catch (InputMismatchException e) {
			System.out.println("a non-existent choice");
			closeApp();
		} catch (InvalidProductException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			closeApp();
		}
	}

	/**
	 * close App
	 */
	public static void closeApp() {
		sc.close();
		try {
			if (!con.getConnection().isClosed() || con.getConnection() != null)
				con.closeConection();
		} catch (ClassNotFoundException | SQLException | IOException | NullPointerException e) {

		}
		System.out.println("Good Bye");
		System.exit(0);

	}

}
