package leetcode150daysMath;

import java.util.Random;

//Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
//
//Implement the Solution class:
//
//Solution(int[] nums) Initializes the object with the integer array nums.
//int[] reset() Resets the array to its original configuration and returns it.
//int[] shuffle() Returns a random shuffling of the array.

public class ShuffleAnArray {

	class Solution {

		int[] arr;

		public Solution(int[] nums) {
			arr = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				arr[i] = nums[i];
			}
		}

		public int[] reset() {
			return arr;
		}

		public int[] shuffle() {
			int[] shuffled = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				shuffled[i] = arr[i];
			}

			Random rnd = new Random();

			for (int i = shuffled.length - 1; i >= 0; i--) {

				int index = rnd.nextInt(i + 1);

				int temp = shuffled[index];
				shuffled[index] = shuffled[i];
				shuffled[i] = temp;

			}

			return shuffled;
		}
	}

}
