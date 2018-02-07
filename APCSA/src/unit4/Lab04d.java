package unit4;



public class Lab04d {
	public static void main(String[] args){
	Name person = new Name("Sally Baker");
	System.out.println(person.getFirst());
	System.out.println(person.getLast());
	System.out.println(person);

	person.setName("John Doe");
	System.out.println(person.getFirst());
	System.out.println(person.getLast());
	System.out.println(person);

	person.setName("Sammy Lammy");
	System.out.println(person.getFirst());
	System.out.println(person.getLast());
	System.out.println(person);

	person.setName("Benny Programmer");
	System.out.println(person.getFirst());
	System.out.println(person.getLast());
	System.out.println(person);

	person.setName("Sandy Painter");
	System.out.println(person.getFirst());
	System.out.println(person.getLast());
	System.out.println(person);

}
}
class Name
{
private String name;

public Name()
{
	

}

public Name(String s)
{
	setName(s);

}

public void setName(String s)
{
   this.name = s;

}

public String getFirst()
{
	String[] arr = name.split(" ");
	return arr[0];
}

public String getLast()
{
	String[] arr = name.split(" ");
	return arr[1];
}

	public String toString()
	{
		return name + "\n\n";
}
}

