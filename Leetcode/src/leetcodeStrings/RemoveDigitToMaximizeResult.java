package leetcodeStrings;

//You are given a string number representing a positive integer and a character digit.

//
//Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.

//Input: number = "123", digit = "3"
//Output: "12"
public class RemoveDigitToMaximizeResult {

	public String removeDigit(String number, char digit) {

		// which one to remove -->

		int index = 0;
		for (int i = 0; i < number.length(); i++) {

			char curr = number.charAt(i);

			// if the current element == digit to remove, check if the next element is
			// greater.
			// if next is greater, directly remove this as we cannot get a larger digit
			if (curr == digit) {

				if (i < number.length() - 1) {
					if (number.charAt(i + 1) > curr) {
						index = i;
						break;
					}
				}

				// if next element is not greater, save this index and go ahead to check if
				// there exists another index that satisfies first case
				index = i;
			}
		}

		// index will have the value of digit to be removed
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < number.length(); i++) {
			if (i == index)
				continue;
			sb.append(number.charAt(i));
		}

		return sb.toString();
	}
}
