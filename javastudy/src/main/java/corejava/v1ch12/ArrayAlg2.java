package v1ch12;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ArrayAlg2 {
	
	public static <T extends Comparable> Pair<T> minmax(T[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		T min = a[0];
		T max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) < 0) {
				min = a[i];
			}

			if (max.compareTo(a[i]) > 0) {
				max = a[i];
			}
		}

		return new Pair<T>(min, max);
	}

	public static <T extends Comparable<T>> T getMiddle(T[] a) {
		return a[a.length / 2];
	}
	
	//T extends Comparable<T> & Serializable
	public static <T extends Comparable<T>> T getMin(T[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		T min = a[0];

		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) < 0) {
				min = a[i];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		String[] aStrings = new String[] { "Hello", "World", "Xinjian", "Beijing", "haidian" };

		System.out.println(ArrayAlg2.minmax(aStrings));
		System.out.println(ArrayAlg2.getMiddle(aStrings));
		System.out.println(ArrayAlg2.getMin(aStrings));
		
		GregorianCalendar[] birthdays = {
				new GregorianCalendar(1906, Calendar.DECEMBER, 9), //
				new GregorianCalendar(1815, Calendar.DECEMBER, 10),
				new GregorianCalendar(1903, Calendar.DECEMBER, 3),
				new GregorianCalendar(1910, Calendar.JUNE, 22)
		};
		
		Pair<GregorianCalendar> mm = ArrayAlg2.minmax(birthdays);
		System.out.println(mm.getFirst().getTime());
		System.out.println(mm.getSecond().getTime());
	}
}
