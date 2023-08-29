package leetcode150daysBinarySearch;

//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		if (n == 1)
			return 1;

		int mid;
		int left = 1, right = n;
		int res = 1;
		while (left <= right) {
			mid = left + (right - left) / 2;

			if (mid == 0) { // if mid is bad , 0==bad
				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;

	}

}
