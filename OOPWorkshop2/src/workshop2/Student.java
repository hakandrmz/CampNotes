package workshop2;

public class Student extends User{
	
	private String schoolName;
	private Course[] courses;
	public Student() {
		super();
	}
	public Student(int id, String firstName, String lastName, String email,String schoolName) {
		super(id, firstName,lastName,email);
		this.schoolName = schoolName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
	
	
}
