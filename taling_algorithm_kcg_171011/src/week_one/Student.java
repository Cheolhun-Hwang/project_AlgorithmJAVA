package week_one;

public class Student {
	private String name;
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String n, int a) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.age = a;
	}

	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
	public int getAge() {
		return this.age;
	}
}
