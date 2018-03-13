package unit11arrayList;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
import java.util.StringTokenizer;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private ArrayList<Grade> grades;
	
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
		grades=new ArrayList<Grade>();
		for(int i =0;i<n;i++)grades.add(new Grade(Double.parseDouble(st.next())));
	}
	
	public void setGrade(int spot, double grade)
	{
		grades.set(spot, new Grade(grade));
	}
	
	public double getSum()
	{
		double sum=0.0;
		for(int i =0;i<grades.size();i++){
			sum+=grades.get(i).getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for(int i =0;i<grades.size();i++)if(grades.get(i).getNumericGrade()<low) low = grades.get(i).getNumericGrade();
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for(int i =0; i<grades.size();i++) if(grades.get(i).getNumericGrade()>high) high=grades.get(i).getNumericGrade();




		return high;
	}
	
	public int getNumGrades()
	{
		return grades.size();
	}
	public ArrayList<Grade> giveGrades(){return grades;}
	public String toString()
	{
		String output="";
		for(int i =0;i<grades.size();i++){
			output+=grades.get(i)+" ";
		}
		/*output+="\nSum = "+Double.toString(getSum())+"\nnum grades = "+grades.size()+"\n low grade = "+Double.toString(getLowGrade())+"\nHigh grade = "+Double.toString(getHighGrade())+"\n";
		*/





		return output;
	}	
}