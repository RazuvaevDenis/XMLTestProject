package netcracker;
public class PhysicsLecturer extends Lecturer{

	public PhysicsLecturer(String name, String surname, int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	@Override
	public String science() {
		return "My science is physics";
	}

}
