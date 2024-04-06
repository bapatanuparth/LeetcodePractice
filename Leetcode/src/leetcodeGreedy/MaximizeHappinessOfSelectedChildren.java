package leetcodeGreedy;

import java.util.Arrays;

//You are given an array happiness of length n, and a positive integer k.
//
//There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
//
//In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
//
//Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.

public class MaximizeHappinessOfSelectedChildren {

	public long maximumHappinessSum(int[] happiness, int k) {
		long ans = 0;
		int subtract = 0;
		Arrays.sort(happiness);

		for (int i = happiness.length - 1; i >= 0 && k > 0; i--, --k) {
			int currHappiness = happiness[i] - subtract;
			if (currHappiness <= 0)
				return ans;
			ans += currHappiness;
			subtract++;
		}

		return ans;
	}

}
