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

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name=name;
		studentList=new Student[stuCount];
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum]=s;

	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double temp=0.0;
		for(int i =0;i<studentList.length;i++){
			temp+=getStudentAverage(i);
		}
		temp/=studentList.length;



		return temp;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		int i=0;
		while(!studentList[i].getName().equals(stuName))i++;
		return getStudentAverage(i);
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		int indexOfHighestStudent = -1;
		for(int i =0;i<studentList.length;i++){
			if(studentList[i].getAverage()>high){
				high=studentList[i].getAverage();
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
		for(int i=0;i<studentList.length;i++){
			if(studentList[i].getAverage()<low){
				low=studentList[i].getAverage();
				indexOfLowestStudent = i;
			}
		}
		hName+=getStudentName(indexOfLowestStudent);
		return hName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		for(int i =0;i<studentList.length;i++){
			if (studentList[i].getAverage()<failingGrade)output+=getStudentName(i)+" ";
		}
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