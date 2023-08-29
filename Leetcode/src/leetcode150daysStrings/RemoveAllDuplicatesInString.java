package leetcode150daysStrings;

//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//
//We repeatedly make duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

public class RemoveAllDuplicatesInString {

	public String removeDuplicates(String S) {
		StringBuilder sb = new StringBuilder();
		int sbLength = 0;
		for (char character : S.toCharArray()) {
			if (sbLength != 0 && character == sb.charAt(sbLength - 1))
				sb.deleteCharAt(sbLength-- - 1);
			else {
				sb.append(character);
				sbLength++;
			}
		}
		return sb.toString();
	}

}
