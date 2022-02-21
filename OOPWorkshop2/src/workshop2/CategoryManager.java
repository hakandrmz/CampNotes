package workshop2;

public class CategoryManager {
	public void add(Category category) {
		System.out.print(category.getName() + " kursu eklenmistir.");
	}	
	public void delete(Category category) {
		System.out.print(category.getName() + " kursu silinmistir.");
	}	
}
