package week2.chapter2.exercise;

import java.util.Arrays;

/**
 * Intersection of two sets. Given two arrays a[] and b[], each containing n
 * distinct 2D points in the plane, design a subquadratic algorithm to count the
 * number of points that are contained both in array a[] and array b[].
 * 
 * @author abdullah.ilhanli
 *
 */
public class Q1 {

	public static int findIntersection(Point[] p1, Point[] p2) {
		Arrays.sort(p1, (a, b) -> Integer.compare(a.a, b.a));
		Arrays.sort(p2, (a, b) -> Integer.compare(a.a, b.a));

		int intersection = 0;
		for (Point p : p1) {
			if (binarySeach(p, p2)) {
				intersection++;
			}
		}
		
		return intersection;

	}

	private static boolean binarySeach(Point p, Point[] p2) {
		int high = p2.length-1;
		int low = 0;

		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (p2[middle].a == p.a && p2[middle].b == p.b) {
				return true;
			} else if (p2[middle].a > p.a) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Point[] points1 = { new Point(1, 2), new Point(4, 5), new Point(12, 1), new Point(0, 2) };
		Point[] points2 = { new Point(1, 2),  new Point(0, 2) };

		System.out.println(findIntersection(points1,points2));
	}

}