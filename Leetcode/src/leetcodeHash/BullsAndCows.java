package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//You are playing the Bulls and Cows game with your friend.
//
//You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
//
//The number of "bulls", which are digits in the guess that are in the correct position.
//The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
//Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
//
//The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

public class BullsAndCows {
	public String getHint(String secret, String guess) {
		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> gmap = new HashMap<>();

		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			else {
				smap.put(secret.charAt(i), smap.getOrDefault(secret.charAt(i), 0) + 1);
				gmap.put(guess.charAt(i), gmap.getOrDefault(guess.charAt(i), 0) + 1);
			}
		}

		for (char ch : gmap.keySet()) {
			if (smap.containsKey(ch)) {
				if (gmap.get(ch) >= smap.get(ch))
					cows += smap.get(ch);
				else
					cows += gmap.get(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(bulls);
		sb.append("A");
		sb.append(cows);
		sb.append("B");

		return sb.toString();
	}

}
