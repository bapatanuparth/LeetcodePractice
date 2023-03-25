package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//You are given an integer array ranks and a character array suits. You have 5 cards where the ith card has a rank of ranks[i] and a suit of suits[i].
//
//The following are the types of poker hands you can make from best to worst:
//
//"Flush": Five cards of the same suit.
//"Three of a Kind": Three cards of the same rank.
//"Pair": Two cards of the same rank.
//"High Card": Any single card.
//Return a string representing the best type of poker hand you can make with the given cards.
//
//Note that the return values are case-sensitive.

public class BestPokerHand {
	public String bestHand(int[] ranks, char[] suits) {
		Map<Integer, Integer> rankmap = new HashMap<>();
		Map<Character, Integer> suitmap = new HashMap<>();

		for (int i : ranks) {
			rankmap.put(i, rankmap.getOrDefault(i, 0) + 1);
		}

		for (char i : suits) {
			suitmap.put(i, suitmap.getOrDefault(i, 0) + 1);
		}

		if (checkFlush(suitmap))
			return "Flush";
		else if (three(rankmap))
			return "Three of a Kind";
		else if (two(rankmap))
			return "Pair";
		else
			return "High Card";

	}

	boolean checkFlush(Map<Character, Integer> suitmap) {
		for (Integer i : suitmap.values()) {
			if (i == 5)
				return true;
		}
		return false;
	}

	boolean three(Map<Integer, Integer> rankmap) {
		for (Integer i : rankmap.values()) {
			if (i >= 3)
				return true;
		}
		return false;
	}

	boolean two(Map<Integer, Integer> rankmap) {
		for (Integer i : rankmap.values()) {
			if (i == 2)
				return true;
		}
		return false;
	}
}
