package interview.string;

/**
 * Java Program to check if one String is rotation of other. In this program, we
 * will see two solution of this interesting problem, one by using String
 * concatenation and other without using String concatenation.
 * 
 * @author Javin
 *
 */
public class RotateStringDemo {

	/**
	 * Returns true if one string is rotation of another, nulls are not
	 * considered rotation of each other
	 * 
	 * @param str
	 * @param rotated
	 * @return true if rotated is rotation of String str
	 */

	public static boolean isRotatedVersion(String str, String rotated) {
		boolean isRotated = false;

		if (str == null || rotated == null) {
			return false;
		} else if (str.length() != rotated.length()) {
			isRotated = false;
		} else {
			String concatenated = str + str;
			isRotated = concatenated.contains(rotated);
		}

		return isRotated;
	}

	/**
	 * Return true if rotated is rotation of input String
	 * 
	 * @param input
	 * @param rotated
	 * @return true if one String is rotation of other
	 */

	public static boolean isRotated(String input, String rotated) {
		if (input == null || rotated == null) {
			return false;
		} else if (input.length() != rotated.length()) {
			return false;
		}

		int index = 0;
		int finalPos = 0;

		do {
			index = rotated.indexOf(input.charAt(0), index);
			if (index < 0) {
				return false;
			}

			// if (input.equalsIgnoreCase(rotated)) {
			// return true;
			// }

			finalPos = rotated.length() - index;
			if (rotated.charAt(0) == input.charAt(finalPos)
					&& input.substring(finalPos).equals(rotated.substring(0, index))) {
				return true;
			}
			
			index += 1;
		} while (index < input.length());

		return false;
	}

	public static void main(String args[]) {
		String test = "abcd";
		String rotated = "dabc";
		boolean isRotated = isRotatedVersion(test, rotated);
		System.out.printf("Is '%s' is rotation of '%s' : %b %n", rotated, test, isRotated);
	}

}
