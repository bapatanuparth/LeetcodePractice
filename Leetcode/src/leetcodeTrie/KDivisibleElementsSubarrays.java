package leetcodeTrie;

public class KDivisibleElementsSubarrays {

//	Given an integer array nums and two integers k and p, return the number of distinct subarrays which have at most k elements divisible by p.
//
//			Two arrays nums1 and nums2 are said to be distinct if:
//
//			They are of different lengths, or
//			There exists at least one index i where nums1[i] != nums2[i].
//			A subarray is defined as a non-empty contiguous sequence of elements in an array.

	public int countDistinct(int[] nums, int k, int p) {
		Trie root = new Trie();
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int c = 0;
			Trie temp = root;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % p == 0)
					c++;
				if (c > k)
					break;
				// use trie to avoid considering duplicate subrrays
				if (temp.ch[nums[j]] == null) {
					temp.ch[nums[j]] = new Trie();
					ans++;
				}
				temp = temp.ch[nums[j]];
			}
		}
		return ans;
	}

	class Trie {
		Trie ch[] = new Trie[201];
	}
}
