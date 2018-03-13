package unit11arrayList;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.*;

public class Class
{
	private String name;
	private ArrayList<Student> studentList;
	
	public Class()
	{
		name="";
		studentList=new ArrayList<Student>();
	}
	
	public Class(String name, int stuCount)
	{
		this.name=name;
		studentList=new ArrayList<Student>();
	
	}
	public ArrayList<Student> giveStudents(){
		return studentList;
	}
	public static ArrayList<Student> sort(Class x){
		Collections.sort(x.giveStudents());
		return x.giveStudents();
	}
	public void addStudent(int stuNum, Student s)
	{
		studentList.add(s);

	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double temp=0.0;
		for(int i =0;i<studentList.size();i++){
			temp+=getStudentAverage(i);
		}
		temp/=studentList.size();



		return temp;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		int i=0;
		while(!studentList.get(i).getName().equals(stuName))i++;
		return getStudentAverage(i);
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList.get(stuNum).getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		int indexOfHighestStudent = -1;
		for(int i =0;i<studentList.size();i++){
			if(studentList.get(i).getAverage()>high){
				high=studentList.get(i).getAverage();
				indexOfHighestStudent =i;
			}
		}
		hName+=getStudentName(indexOfHighestStudent);
		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hName ="";		
		int indexOfLowestStudent = -1;
		for(int i=0;i<studentList.size();i++){
			if(studentList.get(i).getAverage()<low){
				low=studentList.get(i).getAverage();
				indexOfLowestStudent = i;
			}
		}
		hName+=getStudentName(indexOfLowestStudent);
		return hName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="Failure List: ";
		for(int i =0;i<studentList.size();i++){
			if (studentList.get(i).getAverage()<failingGrade)output+=getStudentName(i)+" ";
		}
		output+="\n";
		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		/*
		for(Student i:studentList){
			output+=i+"\n";
		}
		for(Student i:studentList){
			output+=i.getName()+"'s average = "+i.getAverage()+"\n";
		}
*/



		return output;
	}  	
}