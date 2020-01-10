package week2.chapter2.exercise;

public class Point{
	int a, b;

	public Point(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		return "Point [a=" + a + ", b=" + b + "]";
	}
	
	
}