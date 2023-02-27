package leetcodeStack;
//You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

//
//A 0-indexed string num of length n + 1 is created using the following conditions:
//
//num consists of the digits '1' to '9', where each digit is used at most once.
//If pattern[i] == 'I', then num[i] < num[i + 1].
//If pattern[i] == 'D', then num[i] > num[i + 1].
//Return the lexicographically smallest possible string num that meets the conditions.

public class SmallestNumberFromDIString {

	// use stack, for string length 9, consider all digits from 1 2 3 4 5 6 7 8 9
	// now whenever u visit a D, do not append it in final res directly. whenever u
	// visit an I, reverse all the data and append
	// to cases -- if II comes, then each time we append new digit which we want.
	// if I comes after a D, we will have data in stack, and for D, we will need it
	// decreasing, so we reverse the data
	// at the end of the string, there can be a case like DDD, so we append all the
	// accumulated numbers in reverse order\
	// so this way, for any Is we will get data increasing in level and for Ds, we
	// will get data in decreasing
	public String smallestNumber(String pattern) {

		StringBuilder sb = new StringBuilder();
		StringBuilder stack = new StringBuilder();

		for (int i = 0; i <= pattern.length(); i++) {

			stack.append((char) ('1' + i));
			if (i == pattern.length() || pattern.charAt(i) == 'I') {
				sb.append(stack.reverse());
				stack = new StringBuilder();
			}
		}

		return sb.toString();
	}
}
