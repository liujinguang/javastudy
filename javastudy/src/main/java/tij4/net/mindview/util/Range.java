package tij4.net.mindview.util;

public class Range {
	/**
	 * produce a sequence [0, n)
	 * @param n
	 * @return
	 */
	public static int[] range(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		
		return result;
	}
	
	/**
	 * Produce a sequence [start, end)
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] range(int start, int end) {
		int size = end-start;
		int [] result = new int[size];
		for (int i =0;i<size;i++) {
			result[i] = start+i;
		}
		
		return result;
	}
	
	/**produce a sequence (start, end) increment by step
	 * @param start
	 * @param end
	 * @param step
	 * @return
	 */
	public static int[] range(int start, int end, int step) {
		int size = (end-start)/step	;
		int [] result = new int[size];
		for (int i=0;i<size;i++) {
			result[i] = start + (i * step);
		}
		
		return result;
	}
}
