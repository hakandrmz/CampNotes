package workshop2;

public class CourseManager {
	
	public Course[] existCourses;
	
	public void save(Course course) {
		System.out.print( course.getName() + " kursu eklenmitir");
	}
	
	public void addStudentToCourse(Course course,Student student) {
		System.out.print(course.getName() + " kursuna " + student.getFirstName() + " ögrencisi eklenmistir");
	}
	
	public String getCourseList() {
		//return Arrays.asList(this.existCourses);
		return "Kurslarin listesi";
	}
}
