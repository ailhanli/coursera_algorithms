package week2.chapter2.examples;

class MyDate implements Comparable<MyDate> {
	Integer year, month, day, hour, minute, second;

	public MyDate(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public int compareTo(MyDate o) {
		if (year < o.year)
			return -1;
		if (year > o.year)
			return +1;

		if (month < o.month)
			return -1;
		if (month > o.month)
			return +1;

		if (day < o.day)
			return -1;
		if (day > o.day)
			return +1;

		if (hour < o.hour)
			return -1;
		if (hour > o.hour)
			return +1;

		if (minute < o.minute)
			return -1;
		if (minute > o.minute)
			return +1;

		if (second < o.second)
			return -1;
		if (second > o.second)
			return +1;

		return 0;
	}
}

public class CalendarSortExample {

	public static void main(String[] args) {
		System.out.println(new MyDate(2020,01 , 01, 12, 12, 11).compareTo(new MyDate(2019, 12, 01, 12, 12, 12)));
	}

}