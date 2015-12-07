package netcracker;
public class CSFStudent extends Student {

	public CSFStudent(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	@Override
	public String faculty() {
		return "My faculty is CSF";
	}

}
