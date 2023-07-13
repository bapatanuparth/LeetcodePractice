package leetcode150daysArrays;

//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//
//Return the array in the form [x1,y1,x2,y2,...,xn,yn].

public class ShuffleTheArray {

	public int[] shuffle(int[] nums, int n) {
		int[] arr = new int[nums.length];
		int i = 0, j = 0;
		for (; n < nums.length; n++) {
			arr[j] = nums[i];
			i++;
			j++;
			arr[j] = nums[n];
			j++;
		}

		return arr;
	}
}
