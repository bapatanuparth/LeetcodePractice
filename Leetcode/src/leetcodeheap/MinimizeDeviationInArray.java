package leetcodeheap;

import java.util.Collections;
import java.util.PriorityQueue;

//You are given an array nums of n positive integers.
//
//You can perform two types of operations on any element of the array any number of times:
//
//If the element is even, divide it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
//If the element is odd, multiply it by 2.
//For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
//The deviation of the array is the maximum difference between any two elements in the array.
//
//Return the minimum deviation the array can have after performing some number of operations.

public class MinimizeDeviationInArray {

//	If the element is even, we can not increase it.
//	If the element is odd, we can not decrease it.
//	We can try to increase all numbers to their maximum and reduce them step by step.

//	Step 1: Initialize a max-heap evens.
//
//	For an even number in nums, put it directly into evens; for the odd number in nums, multiply by 2 and put it into evens.
//	Step 2: Maintain an integer minimum to keep tracking the smallest element in evens.
//
//	Step 3: Take out the maximum number in evens. Use the maximum and the maintained minimum to update the minimum deviation. If the maximum number is even, divide by 2 and push into evens.
//
//	Step 4: Repeat Step 3 until the maximum number in evens is odd.
//
//	Step 5: Return the minimum deviation.

	public int minimumDeviation(int[] nums) {

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int min = Integer.MAX_VALUE;

		for (int num : nums) {

			if (num % 2 == 1)
				num *= 2;
			q.add(num);
			min = Math.min(num, min);
		}

		int minDeviation = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int curr = q.poll();
			minDeviation = Math.min(minDeviation, curr - min);
			if (curr % 2 == 0) {
				q.add(curr / 2);
				min = Math.min(min, curr / 2);
			} else
				break;
		}

		return minDeviation;

	}

}
