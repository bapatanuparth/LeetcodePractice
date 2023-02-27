package leetcodeheap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

//	The invariant of the algorithm is two heaps, small and large, each represent half of the current list. The length of smaller half is kept to be n / 2 at all time and the length of the larger half is either n / 2 or n / 2 + 1 depend on n's parity.
//
//	This way we only need to peek the two heaps' top number to calculate median.
//
//	Any time before we add a new number, there are two scenarios, (total n numbers, k = n / 2):
//
//	(1) length of (small, large) == (k, k)
//	(2) length of (small, large) == (k, k + 1)
//	After adding the number, total (n + 1) numbers, they will become:
//
//	(1) length of (small, large) == (k, k + 1)
//	(2) length of (small, large) == (k + 1, k + 1)
//	Here we take the first scenario for example, we know the large will gain one more item and small will remain the same size, but we cannot just push the item into large. What we should do is we push the new number into small and pop the maximum item from small then push it into large (all the pop and push here are heappop and heappush). By doing this kind of operations for the two scenarios we can keep our invariant.
	PriorityQueue<Integer> large = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> small = new PriorityQueue<>();
	boolean even = true;

	public FindMedianFromDataStream() {

	}

	public void addNum(int num) {
		if (even) {
			small.offer(num);
			large.offer(small.poll());
		} else {
			large.offer(num);
			small.offer(large.poll());
		}
		even = !even;
	}

	public double findMedian() {
		if (even) {
			return (small.peek() + large.peek()) / 2.0;
		} else {
			return large.peek();
		}

	}
}
