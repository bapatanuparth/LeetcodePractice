package leetCodeArrays2;

import java.util.ArrayList;
import java.util.List;

//You are playing a Flip Game with your friend.
//
//You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.
//
//Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].

public class FlipGame {

	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
			}
		}
		return list;
	}
}
