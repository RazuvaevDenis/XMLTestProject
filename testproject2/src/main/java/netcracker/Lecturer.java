package netcracker;
public abstract class Lecturer implements Person {
	protected String name;
	protected String surname;
	protected int age;
	
	public String getName(){
		return "My name is " +name;
	}
	
	public String getSurname(){
		return "My surname is " + surname;
	}
	
	public String getAge(){
		return "My age is " + age;
	}
	
	public String getPosition(){
		return "I am a lecturer";
	}
	public abstract String science();
}
