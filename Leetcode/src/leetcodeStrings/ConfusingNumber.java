package leetcodeStrings;

//A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
//
//We can rotate digits of a number by 180 degrees to form new digits.
//
//When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
//When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
//Note that after rotating a number, we can ignore leading zeros.
//
//For example, after rotating 8000, we have 0008 which is considered as just 8.
//Given an integer n, return true if it is a confusing number, or false otherwise.

public class ConfusingNumber {
	class Solution {
		public boolean confusingNumber(int n) {
			int temp = n;
			StringBuilder sb = new StringBuilder();
			int arr[] = new int[10];
			if (n == 0)
				return false;
			arr[0] = 0;
			arr[1] = 1;
			arr[2] = -1;
			arr[3] = -1;
			arr[4] = -1;
			arr[5] = -1;
			arr[6] = 9;
			arr[7] = -1;
			arr[8] = 8;
			arr[9] = 6;
			while (n > 0) {
				int x = n % 10;
				if (arr[x] == -1)
					return false;
				sb.append(arr[x]);
				n /= 10;
			}

			StringBuilder sb2 = new StringBuilder();
			sb2.append(temp);

			return !sb.toString().equals(sb2.toString());
		}
	}

}
