package workshop2;

public class StudentManager {
	public void add(Student student) {
		System.out.print(student.getFirstName() + " ogrencisi kayit edilmistir.");
	}
	public void delete(Student student) {
		System.out.print(student.getFirstName() + " ogrencisi silinmistir.");
	}
	public void update(Student student) {
		System.out.print(student.getFirstName() + " ogrencisi guncellenmistir.");
	}
}
