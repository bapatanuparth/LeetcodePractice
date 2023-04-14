package leetcodeBinarySearch;

import java.util.Arrays;

//You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
//
//You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
//
//Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
public class SuccessfulPairsOfSpellsAndPotions {

	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		Arrays.sort(potions);
		int res[] = new int[spells.length];
		int n = potions.length;
		int i = 0;
		for (int spell : spells) {
			int count = checkSpell(spell, potions, success);
			if (count == Integer.MAX_VALUE)
				res[i] = 0;
			else
				res[i] = n - count;
			i++;
		}

		return res;
	}

	int checkSpell(int spell, int potions[], long success) {

		int left = 0, right = potions.length - 1;
		int ans = Integer.MAX_VALUE;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if ((long) potions[mid] * spell >= success) {
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else
				left = mid + 1;
		}

		return ans;
	}

}
