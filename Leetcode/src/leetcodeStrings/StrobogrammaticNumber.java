package leetcodeStrings;

//Given a string num which represents an integer, return true if num is a strobogrammatic number.
//
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

//Input: num = "69"
//Output: true

public class StrobogrammaticNumber {

	public boolean isStrobogrammatic(String num) {

		StringBuilder sb = new StringBuilder();
		for (int i = num.length() - 1; i >= 0; i--) {
			char ch = num.charAt(i);
			if (ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '7')
				return false;
			if (ch == '1')
				sb.append('1');
			else if (ch == '6')
				sb.append('9');
			else if (ch == '8')
				sb.append('8');
			else if (ch == '9')
				sb.append('6');
			else
				sb.append('0');
		}

		for (int i = 0; i < num.length(); i++) {
			if (sb.charAt(i) != num.charAt(i))
				return false;
		}

		return true;
	}
}
