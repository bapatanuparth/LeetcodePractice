package leetcodeQueue;

import java.util.ArrayDeque;
import java.util.Arrays;

//You are given an integer array deck. There is a deck of cards where every card has a unique integer. The integer on the ith card is deck[i].
//
//You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
//
//You will do the following steps repeatedly until all cards are revealed:
//
//Take the top card of the deck, reveal it, and take it out of the deck.
//If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
//If there are still unrevealed cards, go back to step 1. Otherwise, stop.
//Return an ordering of the deck that would reveal the cards in increasing order.
//
//Note that the first entry in the answer is considered to be the top of the deck.

public class RevealCardsIncreasingOrder {

	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		int n = deck.length;

		// start building using the sorted queue endpoint
		// use the pattern of how the numbers get added while reaching towards the
		// beginning
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offerLast(deck[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			int num = deck[i];
			int first = q.pollLast();
			q.offerFirst(first);
			q.offerFirst(num);
		}

		int[] res = new int[n];
		int k = 0;
		for (int i : q) {
			res[k] = i;
			k++;
		}

		return res;
	}

}
