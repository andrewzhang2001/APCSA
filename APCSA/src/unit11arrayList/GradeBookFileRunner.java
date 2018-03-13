package unit11arrayList;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;
import java.io.*;
import java.util.*;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws IOException
   {
		out.println("Welcome to the Class Stats program!");
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\unit11\\gradebook.dat"));
		String className = br.readLine();
		int numStudents =Integer.parseInt(br.readLine());
		Class fileClass = new Class(className,numStudents);
		for(int i =0;i<numStudents;i++){
			String studentName = br.readLine();
			String studentGrades = br.readLine();
			fileClass.addStudent(i, new Student(studentName,studentGrades));
		}
		out.println(fileClass);
		for(int i=0;i<numStudents;i++){
		out.println(String.format(fileClass.getStudentName(i) + "\'s average = %.2f",fileClass.getStudentAverage(i)));	
		}
		ArrayList<Student> sortedStudents = Class.sort(fileClass);
		out.println("\nSORTED LIST:\n");
		for(int i =0;i<sortedStudents.size();i++){
			out.print(sortedStudents.get(i).getName());
			
			out.print("\t\t"+sortedStudents.get(i).getAverage()+"\n");
		}
		out.println(fileClass.getFailureList(70));
		out.println("Highest average = "+fileClass.getStudentWithHighestAverage());
		out.println("Lowest average = "+fileClass.getStudentWithLowestAverage());
		out.println(String.format("Class Average = %.2f",fileClass.getClassAverage()));











	}		
}