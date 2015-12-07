package netcracker;

public class ChemistryLecturer extends Lecturer{

	public ChemistryLecturer(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	
	@Override
	public String science() {
		return "My science is chemistry";
	}
}
