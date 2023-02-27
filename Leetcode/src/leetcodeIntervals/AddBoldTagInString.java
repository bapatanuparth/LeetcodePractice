package leetcodeIntervals;

//You are given a string s and an array of strings words.
//
//You should add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in words.
//
//If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag.
//If two substrings wrapped by bold tags are consecutive, you should combine them.
//Return s after adding the bold tags.

//Input: s = "abcxyz123", words = ["abc","123"]
//Output: "<b>abc</b>xyz<b>123</b>"
public class AddBoldTagInString {

	public String addBoldTag(String s, String[] words) {

		StringBuilder sb = new StringBuilder();
		int lastlog = 0; // maintain last starting point
		int end = -1;

		for (int start = 0; start < s.length(); start++) {

			for (String d : words) {
				if (s.startsWith(d, start)) { // for each word in dictionary
					end = Math.max(end, start + d.length()); // check whether s has substring containing that word
																// starting from index start
				}
			}

			if (start == end) { // this will happen when start reaches a point where there are no more strings
								// in dictionary that are substrings of s till the index start
				sb.append("<b>" + s.substring(lastlog, start) + "</b>"); // so you append a bold tag string in the
																			// output
			}

			if (start >= end) { // in this condition, it means that there was no substtring found in s starting
								// with start that was equal to a word in dictionary
				// so you append that as a single character in the output
				sb.append(s.charAt(start));
				lastlog = start + 1; // mark lastlog as start+1 to keep a new starting point for any substring if
										// found in dictionary
			}
		}

		if (end >= s.length()) { // if end has reached here, it means there was a substring found at the end
			sb.append("<b>" + s.substring(lastlog) + "</b>"); // join it in the bolded tags
		}

		return sb.toString();
	}
}
