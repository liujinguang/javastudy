package v1ch12;


public class ArrayAlg {
	public static Pair<String> minmax(String[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		String min = a[0];
		String max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) < 0) {
				min = a[i];
			}

			if (max.compareTo(a[i]) > 0) {
				max = a[i];
			}
		}

		return new Pair<String>(min, max);
	}
	
	public static <T extends Comparable<T>> T getMiddle(T[] a) {
		return a[a.length / 2];
	}
	
	//T extends Comparable<T> & Serializable
	public static <T extends Comparable> T getMin(T[] a) {
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

		System.out.println(ArrayAlg.minmax(aStrings));
		System.out.println(ArrayAlg.getMiddle(aStrings));
		System.out.println(ArrayAlg.getMin(aStrings));
		
	}
}
