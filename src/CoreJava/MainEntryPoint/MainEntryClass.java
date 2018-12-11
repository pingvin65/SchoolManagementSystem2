package CoreJava.MainEntryPoint;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import CoreJava.CustomExceptions.StudentRegistrationException;
import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.InstructorDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.DAO.TeachingDAO;
import CoreJava.Exception.InvalidProductException;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Instructor;
import CoreJava.Models.Student;
import CoreJava.Models.Teaching;
import CoreJava.Utility.OracleSQL;

public class MainEntryClass extends OracleSQL {

	static Scanner reader = new Scanner(System.in);
	// private static Teaching tea;

	// private static Attending att;
	// private static Course co;

	/**
	 * 
	 * @throws ClassNotFoundException is Exception
	 * @throws IOException            is Exception
	 */
	public void allIntructors() throws ClassNotFoundException, IOException {
		InstructorDAO insDAO = new InstructorDAO();

		List<Instructor> allIns = insDAO.getAllInstructors();
		System.out.printf("\nInstructors:\n======================================================================\n");
		System.out.printf("%-3s INTRUCTOR NAME \t INSTRUCTOR EMAIL \t INSTRUCTOR SPECIALITY\n", "ID");

		for (Instructor insAGN : allIns) {
			System.out.printf("%-3s %-20s %-23s %s\n", insAGN.getInstructorID(), insAGN.getFullName(),
					insAGN.getEmail(), insAGN.getSpeciality());
		}

	}

	/**
	 * 
	 * @throws ClassNotFoundException is Exception
	 * @throws IOException            is Exception
	 */
	public void allCourse() throws ClassNotFoundException, IOException {
		CourseDAO coDAO = new CourseDAO();

		List<Course> allCo = coDAO.getAllCourses();
		System.out.printf("\nCourses:\n===============================================\n");
		System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");

		for (Course coAGN : allCo) {
			System.out.printf("%-3s %-20s %s\n", coAGN.getCourseID(), coAGN.getCourseName(), coAGN.getMinimumGpa());
		}

	}

	/**
	 * print table
	 */
	public void allCoursesWithInstructor() {
		TeachingDAO teaDAO = new TeachingDAO();
		List<Teaching> teaList = teaDAO.getIntructorsCourses();
//		TeacingInstructorsDAO tidao = new TeacingInstructorsDAO();
//		List<TeacingInstructor> teaList = tidao.getAllTeacingInstructors();
		System.out.printf("COURSE NAME \t COURSE MINIMUN GPA \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n\n");
		for (Teaching teaAGN : teaList) {
			System.out.printf("%-16s %-23s %-23s %s\n", teaAGN.getCourseName(), teaAGN.getMinimumGpa(),
					teaAGN.getFullName(), teaAGN.getEmail());
		}
	}

	/**
	 * 
	 * @param attList is List Attending
	 */
	public void StudentCourses(List<Attending> attList) {
		int counter = 1;
		System.out.printf("\nMy Classes:\n");
		System.out.printf("%-3s COURSE NAME \t INTRUCTOR NAME \t INSTRUCTOR EMAIL\n", "#");
		for (Attending att : attList) {
			System.out.printf("%-3s %-20s %-23s %s\n", counter, att.getCourseName(), att.getFullName(), att.getEmail());
			counter++;

		}
	}

	/**
	 * 
	 * @param coList is List Course
	 */
	public void allCourses(List<Course> coList) {
		int counter = 1;
		System.out.printf("\nAll Courses:\n");
		System.out.printf("%-3s COURSE NAME \t MINIMUN GPA\n", "ID");
		for (Course co : coList) {
			System.out.printf("%-3s %-20s %s\n", counter, co.getCourseName(), co.getMinimumGpa());
			counter++;
		}
	}

	/**
	 * closeAll
	 */
	public void closeAll() {
		System.out.print("\nGoodbye!");
		reader.close();
		closeStmt();
		closeConection();

		System.exit(0);
	}

	public static int userInput() {
		reader.reset();
		return reader.nextInt();
	}

	/**
	 * 
	 * @param args is array String
	 * @throws ClassNotFoundException       is Exception
	 * @throws IOException                  is Exception
	 * @throws StudentRegistrationException is Exception
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, StudentRegistrationException {
		boolean quit = false;

		MainEntryClass mainObj = new MainEntryClass();
		int InsOrStu = -1;
		Instructor ins = null;
		InstructorDAO insDAO = null;
		String insROLE = "";

		Student stu = null;
		StudentDAO stuDAO = null;

		// setCo(null);
		CourseDAO coDAO = null;

		// setAtt(null);
		AttendingDAO attDAO = null;

		// setTea(null);
		TeachingDAO teaDAO = null;

		String email = "";
		String password = "";
		while (!quit) {
			System.out.print("Are you a(n)\n1. Instructor \n2. Student \n3. quit \nPlease, enter 1, 2 or 3 \n>");
			try {
				InsOrStu = userInput();//InsOrStu = reader.nextInt();
				if (InsOrStu < 1 || InsOrStu > 3) {

					throw new InvalidProductException(
							"No number with your choice -->  " + InsOrStu + "\nPlease, enter 1, 2 or 3\n");
				}
			} catch (InputMismatchException e) {
				System.err.println("Please number, enter 1, 2 or 3 next time");

				mainObj.closeAll();
			} catch (InvalidProductException ex) {

				System.err.println(ex.getMessage());

				// closeAll();
			}
			if (InsOrStu == 1) {
				boolean logout = false;
				while (!logout) {
					System.out.print("\nEnter Your Email:\n>");
					email = reader.next();
					System.out.print("\nEnter Your Password:\n>");
					password = reader.next();
					insDAO = new InstructorDAO();
					ins = insDAO.getInstructoByEmail(email);
					try {
						insROLE = insDAO.validateUser(ins, password);
					} catch (NullPointerException e) {
						insROLE = insDAO.getInstructorRouls()[2];
					}

					if ("Admin".equals(insROLE)) {
						teaDAO = new TeachingDAO();
						mainObj.allCoursesWithInstructor();
						String out = "-1";
						while (!out.equals("2")) {
							System.out.printf("\n\n");
							System.out.println("1. Assign Instructor to Course");
							System.out.println("2. Logout");
							out = reader.next();

							if (out.equals("1")) {
								int instructor_id = -1;
								int course_id = -1;
								mainObj.allIntructors();
								System.out.println("\nWhat Instructor?\n");
								try {
									instructor_id = reader.nextInt();
								} catch (InputMismatchException e) {
									System.err.println("wrong entry");

									mainObj.closeAll();
								}
								mainObj.allCourse();
								System.out.println("\nWhich Course?\n");
								course_id = reader.nextInt();
								int assignId = teaDAO.assignInstructorToCourse(course_id, instructor_id);
								if (assignId != -1) {
									System.out
											.println("\n -->Instructor Assigned<--\nNew Record Id: " + assignId + "\n");
								} else {
									System.out.println("\n -->The instructor already has a course :\nwith ID  "
											+ course_id + "  \n");
								}
								mainObj.allCoursesWithInstructor();
							}
						}
						System.out.printf("\n\n");
						logout = true;
					} else if ("Instructor".equals(insROLE)) {
						coDAO = new CourseDAO();
						List<Course> coList = coDAO.getCourseByInstructor(ins.getInstructorID());
						System.out.printf("\nCOURSE NAME \t COURSE MINIMUN GPA\n");
						for (Course insCO : coList) {
							System.out.printf("%s \t\t %s\n", insCO.getCourseName(), insCO.getMinimumGpa());
						}
						String out = "-1";
						while (!out.equals("1")) {
							System.out.print("\n1. Logout\n>");
							out = reader.next();
						}
						ins = null;
						logout = true;
					} else if ("Wrong Credentials".equals(insROLE)) {
						System.out.println("\n" + insROLE);
						continue;
					}

				}

			} else if (InsOrStu == 2) {
				stuDAO = new StudentDAO();
				attDAO = new AttendingDAO();
				boolean logout = false;
				while (!logout) {
					System.out.print("\nEnter Your Email:\n>");
					email = reader.next();
					System.out.print("\nEnter Your Password:\n>");
					password = reader.next();

					List<Attending> attList = null;
					stu = stuDAO.getStudentByEmail(email);

					if (stu != null && stu.getStudentRole() == -1 && stuDAO.validateUser(stu.getPass(), password)) {

						String classesTo = "";
						while (!classesTo.equals("2")) {
							attList = attDAO.getStudentCourse1(stu.getStudentID());
							mainObj.StudentCourses(attList);
							System.out.printf("\n1. Register to Class");
							System.out.printf("\n2. Logout\n>");
							classesTo = reader.next();
							if (classesTo.equals("1")) {
								coDAO = new CourseDAO();
								attDAO = new AttendingDAO();
								List<Course> coList = coDAO.getAllCourses();
								mainObj.allCourses(coList);
								System.out.println("\nWhich Course?\n");

								int course_idForStudent = 0;
								try {
									course_idForStudent = reader.nextInt();
								} catch (InputMismatchException e) {
									mainObj.allCourse();
								}
								try {
									attDAO.registerStudentToCourse(stu, coList.get(course_idForStudent - 1));
								} catch (IndexOutOfBoundsException e) {
									System.err.print("no Course\n");
								}
								classesTo = "";
							}
						}
						logout = true;
					} else {
						System.out.printf("\n\nWrong Credentials\n");
						continue;
					}
				}

			} else if (InsOrStu == 3) {
				mainObj.closeAll();
				quit = true;
			}
		}

	}

}
