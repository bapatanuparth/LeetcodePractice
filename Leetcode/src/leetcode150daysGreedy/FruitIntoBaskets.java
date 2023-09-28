package leetcode150daysGreedy;

import java.util.HashMap;
import java.util.Map;

//You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//
//You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//
//You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//Given the integer array fruits, return the maximum number of fruits you can pick.

public class FruitIntoBaskets {
	public int totalFruit(int[] fruits) {
		if (fruits.length <= 2)
			return fruits.length;
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0, j = 0;

		while (j < fruits.length) {
			if (map.size() <= 2) {
				map.put(fruits[j], j++); // store each fruit with its latest index value
			}
			if (map.size() > 2) {
				int min = fruits.length - 1;
				for (int m : map.values()) {
					min = Math.min(min, m);
				}
				i = min + 1;
				map.remove(fruits[min]);
			}

			max = Math.max(max, j - i);
		}

		return max;
	}
}
