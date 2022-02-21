package workshop2;

public class Course {
	
	private int id;
	private String name;	
	private String description;
	private int price;
	
	private String[] images;	
	private Category category;
	private Instructor[] instructers;
	private Student[] students;
	
	public Course() {
		super();
	}
	public Course(int id, String name, String description, int price, String[] images) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Instructor[] getInstructers() {
		return instructers;
	}
	public void setInstructers(Instructor[] instructers) {
		this.instructers = instructers;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	

}
