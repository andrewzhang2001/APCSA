package unit11;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner keyboard = new Scanner(System.in);
		out.println("What is the name of this class");
		String className = keyboard.nextLine();
		out.println("How many students are in this class?");
		int numStudents = keyboard.nextInt();
		keyboard.nextLine();
		Class ipC=new Class(className,numStudents);
		for(int i =0;i<numStudents;i++){
			out.println("Enter the name of Student 1: ");
			String studentName = keyboard.nextLine();
			out.println("Enter the grades for "+studentName+"\nUse the format x - grades ; example: 3 - 100 99 98");
			//System.out.println(keyboard.next()+"xd");
			String studentGrades = keyboard.nextLine();
			Student s=new Student(studentName, studentGrades);
			ipC.addStudent(i, s);
		}
		out.println(ipC);
		for(int i=0;i<numStudents;i++){
		out.println(String.format(ipC.getStudentName(i) + "\'s average = %.2f",ipC.getStudentAverage(i)));	
		}
		out.println(ipC.getFailureList(5));
		out.println(String.format("Class Average = %.2f",ipC.getClassAverage()));	
	}		
}