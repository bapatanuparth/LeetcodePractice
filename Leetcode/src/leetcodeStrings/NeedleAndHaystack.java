package leetcodeStrings;

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class NeedleAndHaystack {

	class Solution {
		public int strStr(String haystack, String needle) {

			for (int i = 0;; i++) {

				for (int j = 0;; j++) {
					if (j == needle.length())
						return i;
					if ((i + j) >= haystack.length())
						return -1;
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
				}

			}
		}

	}
}
