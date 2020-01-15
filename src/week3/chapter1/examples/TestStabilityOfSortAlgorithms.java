package week3.chapter1.examples;

import java.util.Arrays;

class Student {
	String name;
	Integer age;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}

public class TestStabilityOfSortAlgorithms {

	public static void main(String[] args) {
		Student[] std = { new Student("Mali", 26), new Student("Ali", 10), new Student("Ali", 45),
				new Student("Nuri", 40) };
		
		Arrays.sort(std, (s1,s2)->s1.getName().compareTo(s2.getName()));
		Arrays.sort(std, (s1,s2)->Integer.compare(s1.getAge(), s2.getAge()));
		
		Arrays.stream(std).forEach(System.out::println);
	}
}