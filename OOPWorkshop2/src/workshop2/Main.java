package workshop2;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		Student student1 = new Student(1,"Furkan Halil","Er","furkan@mail.com","itü");
		Student student2 = new Student(2,"Oguzhan","Bulbul","oguz@mail.com","gümüshane");
		
		Instructor instructor1 = new Instructor(1,"Engin","Demirog","engin@mail.com",10,"engin.jpg");
		Instructor instructor2 = new Instructor(2,"Hakan","Durmaz","hakan0@mail.com",9,"hakan.jpg");
		
		Category category = new Category(1,"Yazilim");
		
		Course course1 = new Course(1,
				"Java Programlama",
				"Java Nesneye Yönelik Programlama",
				15,
				new String[] {"java1.jpg","java2.jpg"});
		Course course2 = new Course(2,
				"C# Programlama",
				"C# Nesneye Yönelik Programlama",
				16,
				new String[] {"c1.jpg","c2.jpg"});
		
		course1.setCategory(category);
		course1.setInstructers(new Instructor[] {instructor1,instructor2});
		
		course2.setCategory(category);
		course2.setInstructers(new Instructor[] {instructor2});	
		
		course1.setStudents(new Student[] {student1,student2});
		course2.setStudents(new Student[] {student2});
		
		student1.setCourses(new Course[] {course1,course2});
		student2.setCourses(new Course[] {course2});		
		/*
		for (Course course : new Course[] {course1,course2}) {
			System.out.println("------------------------");
			System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println(course.getDescription());
			System.out.println(course.getCategory().getName());
			System.out.println(course.getPrice());
			System.out.println(Arrays.toString(course.getImages()));
		}
		*/
		StudentManager studentManager = new StudentManager();
		studentManager.add(student2);
		System.out.println();
		CourseManager courseManager = new CourseManager();
		courseManager.save(course2);
		System.out.println();
		courseManager.addStudentToCourse(course1,student1);	
		System.out.println();
		System.out.println(courseManager.getCourseList());
	}
}
















