package leetcode150daysTwoPointer;

//Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
//
//Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

public class NextGreaterElementII {

	public int nextGreaterElement(int n) {

		char num[] = ("" + n).toCharArray();
		int i = num.length - 2;

		while (i >= 0 && num[i + 1] <= num[i]) {
			i--;
		}
		if (i < 0)
			return -1;
		int j = num.length - 1;

		while (j >= 0 && num[j] <= num[i]) // find number just greater than number ar i
		{
			j--;
		}
		swap(num, i, j);
		reverse(num, i + 1); // we need all the remaining numbers on the right of i to be in ascending order
								// so that we get the least number greater than the current number
		// and all the numbers cuurently starting from i to end are already in
		// descending order
		// because we move back only till we find the first pair for ehich i > i-1
		try {
			// to handle the case of INT_MAX
			// 2147483486
			return Integer.parseInt(new String(num));
		} catch (Exception e) {
			return -1;
		}

	}

	void reverse(char[] num, int start) {
		int i = start, j = num.length - 1;
		while (i < j) {
			swap(num, i, j);
			i++;
			j--;
		}
	}

	void swap(char[] num, int i, int j) {
		char temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
