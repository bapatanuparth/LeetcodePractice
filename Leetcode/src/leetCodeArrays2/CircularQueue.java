package leetCodeArrays2;

public class CircularQueue {

	int[] q;
	int capacity;
	int size = 0;
	int front = 0;
	int rear = -1;

	public CircularQueue(int k) {
		q = new int[k];
		capacity = k;
	}

	public boolean enQueue(int value) {
		if (size == capacity)
			return false;
		q[(++rear) % capacity] = value;
		size++;
		return true;
	}

	public boolean deQueue() {
		if (size == 0)
			return false;
		front++;
		size--;
		return true;
	}

	public int Front() {
		if (size == 0)
			return -1;
		return q[(front % capacity)];
	}

	public int Rear() {
		if (size == 0)
			return -1;
		return q[(rear % capacity)];
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public boolean isFull() {
		if (size == capacity)
			return true;
		return false;
	}
}
