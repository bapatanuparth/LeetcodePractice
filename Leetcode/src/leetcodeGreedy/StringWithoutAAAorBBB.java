package leetcodeGreedy;

//Given two integers a and b, return any string s such that:
//
//s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
//The substring 'aaa' does not occur in s, and
//The substring 'bbb' does not occur in s.

public class StringWithoutAAAorBBB {

//	The possibilities here are
//
//	a == b
//	a > b (a>= 2b || b > a > 2b) ex.- (a=12, b=5 || a=12, b=8)
//	b > a (b >= 2a || a > b > 2a) ex. similar as above
//	we handle these case by case.
//
//	Approach
//	we check for every condition separately-
//
//	In a loop check which of the above condition is true.
//	example - if a >= 2b, then we will append "aa" followed by "b".
//	if this condition doesnt hold true, it means we have b >a >2a, then we append "aa" followed by "bb".
//	the input ensures that we end up with a valid answer
//	if a ==b we append "ab" to the string till they become zero.
	class Solution {
		public String strWithout3a3b(int a, int b) {

			StringBuilder sb = new StringBuilder();
			if (a > b) {
				while (a > 0 && b > 0) {
					if (a >= b * 2) {
						sb.append("aab");
						a -= 2;
						b -= 1;
					} else {
						sb.append("aabb");
						a -= 2;
						b -= 2;
					}
				}
				if (a != 0) {
					while (a != 0) {
						sb.append("a");
						a--;
					}
				}
			} else if (b > a) {
				while (a > 0 && b > 0) {
					if (b >= a * 2) {
						sb.append("bba");
						b -= 2;
						a -= 1;
					} else {
						sb.append("bbaa");
						a -= 2;
						b -= 2;
					}
				}
				if (b != 0) {
					while (b != 0) {
						sb.append("b");
						b--;
					}
				}
			} else {
				while (a > 0 && b > 0) {
					sb.append("a");
					sb.append("b");
					a -= 1;
					b -= 1;
				}
			}

			return sb.toString();
		}
	}

}
