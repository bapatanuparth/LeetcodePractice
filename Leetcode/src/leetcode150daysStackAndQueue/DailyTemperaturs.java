package leetcode150daysStackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

public class DailyTemperaturs {

	public int[] dailyTemperatures(int[] temperatures) {

		Deque<Integer> st = new ArrayDeque<>();
		int[] answer = new int[temperatures.length];

		for (int currday = 0; currday < temperatures.length; currday++) {
			int temp = temperatures[currday];

			while (!st.isEmpty() && temperatures[st.peek()] < temp) {
				int prevDay = st.pop();
				answer[prevDay] = currday - prevDay;
			}
			st.push(currday);
		}
		return answer;

	}

}
