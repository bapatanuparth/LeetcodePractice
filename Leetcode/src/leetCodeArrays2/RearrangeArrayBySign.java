package leetCodeArrays2;

//You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
//
//You should rearrange the elements of nums such that the modified array follows the given conditions:
//
//Every consecutive pair of integers have opposite signs.
//For all integers with the same sign, the order in which they were present in nums is preserved.
//The rearranged array begins with a positive integer.
//Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

//Input: nums = [3,1,-2,-5,2,-4]
//Output: [3,-2,1,-5,2,-4]
public class RearrangeArrayBySign {

	public int[] rearrangeArrayEff(int[] nums) {
		int ans[] = new int[nums.length];
		int indexpos = 0, indexneg = 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ans[indexpos] = nums[i];
				indexpos += 2;
			}
			if (nums[i] < 0) {
				ans[indexneg] = nums[i];
				indexneg += 2;
			}
		}

		return ans;
	}

	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;

		int pos[] = new int[n / 2];
		int neg[] = new int[n / 2];

		// get pos and neg elements in separate arrays
		int ind1 = 0, ind2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				pos[ind1] = nums[i];
				ind1++;
			} else if (nums[i] < 0) {
				neg[ind2] = nums[i];
				ind2++;
			}
		}

		// append from separate arrays
		int res[] = new int[n];
		int k = 0;
		ind1 = 0;
		ind2 = 0;
		while (ind1 < pos.length && ind2 < neg.length) {
			res[k] = pos[ind1];
			ind1++;
			k++;
			res[k] = neg[ind2];
			ind2++;
			k++;
		}

		return res;
	}
}
