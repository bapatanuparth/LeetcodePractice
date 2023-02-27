package leetcodeInterviewPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinKeyPresses {

	public int minimumKeypressesEff(String s) {
		// count same letters - this is effectively map from char to occurrence but
		// faster since it's an array
		int[] occurrences = new int[26];
		for (char c : s.toCharArray()) {
			++occurrences[c - 'a'];
		}
		// sort from the rarest occurrence to the highest occurrence
		// - can't do easily Comparator.reverseOrder() without conversion, so we go from
		// back of the array
		Arrays.sort(occurrences);
		// placeReservation serves for binding to the keyboard (for operation modulo 9)
		int placeReservation = 0;
		int minimumKeypresses = 0;
		for (int index = occurrences.length - 1; index >= 0; --index) {
			int i = occurrences[index];
			if (i == 0) {
				break;
			}
			// +1 because minimum 1 click on keyboard
			minimumKeypresses += ((placeReservation / 9) + 1) * i;
			++placeReservation;
		}
		return minimumKeypresses;
	}

	// idea is to make the characters with max frequency of occurrence be put in 1st
	// place
	public int minimumKeypresses(String s) {
		Map<Character, Integer> map = new HashMap<>();

		// calculate frequency of occurrence
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		// arrange the characters acc to descending order of their freq
		Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (char ch : map.keySet()) {
			int a = ch - 'a';
			int b = map.get(ch);
			q.add(new int[] { a, b });
		}

		// based on the char frequency, give values to each character
		int[] arr = new int[26];

		int count = 1;
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			// if frequency in top 9, make it available on a single click
			if (count < 10) {
				arr[temp[0]] = 1;
				// if 10<freq<18 it should be at the 2 presses
			} else if (count >= 10 && count < 19) {
				arr[temp[0]] = 2;
			} else { // remaining at the end
				arr[temp[0]] = 3;
			}
			count++;
		}

		int ans = 0;// for each character, find its value of keypressesd and add to answer
		for (int i = 0; i < s.length(); i++) {
			int t = arr[s.charAt(i) - 'a'];
			ans += t;
		}

		return ans;

	}
}
