package leetcodeGreedy;

//Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
//
//However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
//
//Return the least number of units of times that the CPU will take to finish all the given tasks.

public class TaskScheduler {

//	E.g. we have following tasks : 3 A, 2 B, 1 C. and we have n = 2. According to what we have above, we should first arrange A, and then B and C. Imagine there are "slots" and we need to arrange tasks by putting them into "slots". Then A should be put into slot 0, 3, 6 since we need to have at least n = 2 other tasks between two A. After A put into slots, it looks like this:
//
//		A ? ? A ? ? A
//		"?" is "empty" slots.
//	We can see that A separated slots into (count(A) - 1) = 2 parts, each part has length n. 
	// With the fact that A is the task with most frequency, it should need more
	// idles than any other tasks.
	// In this case if we can get how many idles we need to arrange A, we will also
	// get number of idles needed to arrange all tasks. Calculating this is not
	// hard,
	// we first get number of parts separated by A: partCount = count(A) - 1; then
	// we can know number of empty slots:
	// emptySlots = partCount * n; we can also get how many tasks we have to put
	// into those slots: availableTasks = tasks.length - count(A). Now if we have
	// emptySlots > availableTasks which means we have not enough tasks available to
	// fill all empty slots, we must fill them with idles. Thus we have idles =
	// max(0, emptySlots - availableTasks);

	public int leastInterval(char[] tasks, int n) {

		char[] freq = new char[26];
		int max = 0;
		int maxCount = 0;
		for (int i = 0; i < tasks.length; i++) {
			freq[tasks[i] - 'A']++;

			if (max == freq[tasks[i] - 'A'])
				maxCount++; // increase count of elements with max frequency
			else if (max < freq[tasks[i] - 'A']) {
				max = freq[tasks[i] - 'A'];
				maxCount = 1;
			}
		}

		int partCount = max - 1; // count of parts of string made due to highest occurring element
		int partLength = n - (maxCount - 1); // number of remaining spaces in each part
		int emptySlots = partCount * partLength;
		int availableTasks = tasks.length - max * maxCount; // remaining tasks to be used to fill the space
		int idles = Math.max(0, emptySlots - availableTasks); // calculate the idles that we need

		return tasks.length + idles;
	}
}
