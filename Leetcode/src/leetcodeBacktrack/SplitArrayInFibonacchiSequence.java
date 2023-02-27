package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInFibonacchiSequence {

	public List<Integer> splitIntoFibonacci(String num) {
		List<Integer> result = new ArrayList<>();
		backtrack(num, result, 0);
		return result;
	}

	boolean backtrack(String s, List<Integer> result, int ind) {
		if (ind == s.length()) // true only when we reach the end and have more than 2 splits of input as a
								// solution
		{
			return result.size() > 2;
		}

		int num = 0;
		for (int i = ind; i < s.length(); i++) {
			num = (num * 10) + (s.charAt(i) - '0');// add current element to result,in each iteration, this will addnext
													// //string character to the number. this way our number will grow
													// at each iteration

			if (num < 0)
				return false;

			if (result.size() < 2 || result.get(result.size() - 1) + result.get(result.size() - 2) == num) {
				result.add(num); // add elements in the result till we reach the end of string

				if (backtrack(s, result, i + 1))
					return true;

				result.remove(result.size() - 1);
			}

			if (i == ind && s.charAt(i) == '0') // to catch a leading zero
				return false;
		}

		return false;
	}
}
