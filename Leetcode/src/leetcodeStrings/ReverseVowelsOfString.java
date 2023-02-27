package leetcodeStrings;

public class ReverseVowelsOfString {

	public String reverseVowels(String s) {

		int left = 0, right = s.length() - 1;
		StringBuilder sb = new StringBuilder(s);

		while (left < right) {

			// move left and right till both have vowel, then swap
			boolean isleft = s.charAt(left) == 'a' || s.charAt(left) == 'e' || s.charAt(left) == 'i'
					|| s.charAt(left) == 'o' || s.charAt(left) == 'u' || s.charAt(left) == 'A' || s.charAt(left) == 'E'
					|| s.charAt(left) == 'I' || s.charAt(left) == 'O' || s.charAt(left) == 'U';
			boolean isright = s.charAt(right) == 'a' || s.charAt(right) == 'e' || s.charAt(right) == 'i'
					|| s.charAt(right) == 'o' || s.charAt(right) == 'u' || s.charAt(right) == 'A'
					|| s.charAt(right) == 'E' || s.charAt(right) == 'I' || s.charAt(right) == 'O'
					|| s.charAt(right) == 'U';

			if (isleft && isright) {
				char temp = s.charAt(left);
				sb.replace(left, left + 1, "" + sb.charAt(right));
				sb.replace(right, right + 1, "" + temp);
				left++;
				right--;
			}

			else if (isleft && !isright) {
				right--;
			}

			else if (isright && !isleft) {
				left++;
			}

			else {
				left++;
				right--;
			}
		}

		return sb.toString();

	}
}
