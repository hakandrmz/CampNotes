package workshop2;

public class Instructor extends User{
	
	private int salary;
	private String image;
	
	private Course[] courses;
	public Instructor() {
		super();
	}	
	public Instructor(int id, String firstName, String lastName, String email,int salary, String image) {
		super(id,firstName,lastName,email);
		this.salary = salary;
		this.image = image;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	
	
	
	
}
