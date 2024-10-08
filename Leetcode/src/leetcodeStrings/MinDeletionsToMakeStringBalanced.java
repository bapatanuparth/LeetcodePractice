package leetcodeStrings;

public class MinDeletionsToMakeStringBalanced {

	public int minimumDeletions(String s) {
		int n = s.length();
		int countA[] = new int[n];
		int countB[] = new int[n];
		int bCount = 0;

		for (int i = 0; i < n; i++) {
			countB[i] = bCount;
			if (s.charAt(i) == 'b')
				bCount++;
		}

		int aCount = 0;
		for (int i = n - 1; i >= 0; i--) {
			countA[i] = aCount;
			if (s.charAt(i) == 'a')
				aCount++;
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, countA[i] + countB[i]);
		}

		return ans;

	}
}
