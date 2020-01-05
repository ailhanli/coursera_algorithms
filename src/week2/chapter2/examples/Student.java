package week2.chapter2.examples;

public class Student implements Comparable<Student> {
	String name;
	Integer age;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		return Integer.compare(age, o.age);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}