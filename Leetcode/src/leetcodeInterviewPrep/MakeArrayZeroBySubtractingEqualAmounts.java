package leetcodeInterviewPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {

	// answer is number of unique positive integers as in 1 step u will make a
	// particular positive integer == 0
	// the same integer will take same no of steps to go to zero
	// any repeated # will go to 0 in the same steps

	public int minimumOperations1(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (i > 0)
				set.add(i);
		}

		return set.size();
	}

	// using streams api
	public int minimumOperations(int[] nums) {
		return (int) Arrays.stream(nums).filter(num -> num > 0).distinct().count();
	}
}
