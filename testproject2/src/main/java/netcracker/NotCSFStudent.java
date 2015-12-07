package netcracker;
public class NotCSFStudent extends Student{

	public NotCSFStudent(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	@Override
	public String faculty() {
		return "My faculty is not CSF";
	}

}
