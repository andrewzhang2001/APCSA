package unit11;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private Grade[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		Scanner st = new Scanner(gradeList);
		int n = (st.nextInt());
		String trash = st.next();
		grades=new Grade[n];
		for(int i =0;i<n;i++)grades[i]=new Grade(Double.parseDouble(st.next()));
	}
	
	public void setGrade(int spot, double grade)
	{
		grades[spot]=new Grade(grade);
	}
	
	public double getSum()
	{
		double sum=0.0;
		for(int i =0;i<grades.length;i++){
			sum+=grades[i].getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for(int i =0;i<grades.length;i++)if(grades[i].getNumericGrade()<low) low = grades[i].getNumericGrade();
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for(int i =0; i<grades.length;i++) if(grades[i].getNumericGrade()>high) high=grades[i].getNumericGrade();




		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{
		String output="";
		for(int i =0;i<grades.length;i++){
			output+=grades[i]+" ";
		}
		output+="\nSum = "+Double.toString(getSum())+"\nnum grades = "+grades.length+"\n low grade = "+Double.toString(getLowGrade())+"\nHigh grade = "+Double.toString(getHighGrade())+"\n";
		





		return output;
	}	
}