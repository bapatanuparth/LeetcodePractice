package leetcodeGreedy;

import java.util.Arrays;

//You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.
//
//A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.
//
//Return the number of weak characters.
public class NumberOfWeakCharactersInGame {

	// Greedy O(n+k)
//	 For a pair (a, b) we can say it to be weak if the maximum defense value among all 
	// the pairs with attack-value > a is greater than b. So we will keep the
	// maximum defense value
	// among all the pairs with an attack value greater than x, for every value of
	// x.
	// Then the pair (a, b) will be weak if the maximum defense value stored for
	// value a + 1 is greater
	// than b.
	public int numberOfWeakCharactersEfficient(int[][] properties) {

		int maxattack = 0;

		for (int[] property : properties) {
			int attack = property[0];
			maxattack = Math.max(maxattack, attack);
		}

		int[] maxdefence = new int[maxattack + 2];

		for (int[] property : properties) {
			int attack = property[0];
			int def = property[1];

			maxdefence[attack] = Math.max(maxdefence[attack], def);
		}

		for (int i = maxattack - 1; i >= 0; i--) {
			maxdefence[i] = Math.max(maxdefence[i], maxdefence[i + 1]);
		}

		int weak = 0;
		for (int[] property : properties) {
			int attack = property[0];
			int defence = property[1];

			if (defence < maxdefence[attack + 1])
				weak++;
		}

		return weak;

	}

	// sorting nlogn
	public int numberOfWeakCharacters(int[][] properties) {

		// Sort the array on the basis of the attack values and group characters with
		// the same attack together
		// sorting the pairs by ascending order of their attack value and then in
		// descending order of their defense value in case of a tie.
		// this will ensure that whenever there is a tie of attack value, we wont
		// consider it as weak while going in reverse direction as all tie values will
		// have defence in decreasing order
		// if we come across a lower defence value, it has to have a lower attack value
		// as well
		Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);

		int len = properties.length;
		int weak = 0;
		int maxDefence = 0;

		for (int i = len - 1; i >= 0; i--) {

			if (properties[i][1] < maxDefence) {
				weak++;
			}

			maxDefence = Math.max(maxDefence, properties[i][1]);
		}

		return weak;
	}
}
