package unit8;

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

class Grades
{
	private double[] myList;
	
	

	//constructor
	public Grades (double[] student){
		setValues(student);
	}


	//set method
	public void setValues(double[] bludent){
		myList = bludent;
	}
	



	private double getSum()
	{
		double sum=0.0;
		for(double i:myList){
			sum +=i;
		}



		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		double sum = 0;
		double cnt = 0;
		for(int i =0; i < myList.length; i++){
			sum += myList[i];
			cnt ++;
		}
		average = sum / cnt;


		return average;
	}
	public String toString(){
		String myString = "";
		for(int i = 0; i < myList.length; i++){
			myString += "Grade "+i + ": " + myList[i] + "\n";
		}
		myString += "Average = " + String.format("%.2f", getAverage()) +"\n";
		return myString;
	}


	//toString method



}
public class Lab14D {
	public static void main(String[] args){
		double[] adam = {100, 90, 85, 72.5, 95.6};
		double[] andy = {50, 100, 80};
		double[] ray = {93.4, -90.0, 90.0};
		double[] andrew = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Grades bdam = new Grades(adam);
		System.out.println(bdam);
		Grades bndy = new Grades(andy);
		System.out.println(bndy);
		Grades bay = new Grades(ray);
		System.out.println(bay);
		Grades bndrew = new Grades(andrew);
		System.out.println(bndrew);
	}

}
