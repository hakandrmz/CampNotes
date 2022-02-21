package workshop2;

public class InstructorManager {
	public void add(Instructor instructor) {
		System.out.print("added" + instructor.getFirstName());
	}
	public void delete(Instructor instructor) {
		System.out.print("delete" + instructor.getFirstName());
	}
	public void update(Instructor instructor) {
		System.out.print("update" + instructor.getFirstName());
	}
}
