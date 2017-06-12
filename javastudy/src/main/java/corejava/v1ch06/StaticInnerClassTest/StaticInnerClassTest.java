package v1ch06.StaticInnerClassTest;

public class StaticInnerClassTest {
	public static void main(String[] args) {
		double[] ds = new double[20];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = 100 * Math.random();
		}

		ArrayAlg.Pair pair = ArrayAlg.minmax(ds);

		System.out.println("min = " + pair.getFirst());
		System.out.println("max = " + pair.getSecond());
	}
}

class ArrayAlg {
	public static class Pair {
		public Pair(double first, double second) {
			super();
			this.first = first;
			this.second = second;
		}

		public double getFirst() {
			return first;
		}

		public double getSecond() {
			return second;
		}

		private double first;
		private double second;
	}

	public static Pair minmax(double[] values) {
		double min = Double.MIN_VALUE;
		double max = Double.MAX_VALUE;

		for (double v : values) {
			if (min > v) {
				min = v;
			}
			if (max < v) {
				max = v;
			}
		}

		return new Pair(min, max);
	}
}
