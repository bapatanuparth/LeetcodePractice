package leetcodeHash;

import java.util.LinkedList;

public class DesignHashSet {

	// we need to create an array of linked list.
	// we will do hashing with a large prime number, here 769.
	// for collisions, we will handle it by separate chaining, i.e. we will go on
	// adding new element in the linked list of each element

	class MyHashSet {

		int keyrange;
		Bucket[] bucketarr;

		// the hashset would be an array of linked list, the array size being the max
		// prime number range
		public MyHashSet() {
			this.keyrange = 769;
			this.bucketarr = new Bucket[769];

			for (int i = 0; i < keyrange; i++) {
				this.bucketarr[i] = new Bucket();
			}
		}

		// before inserting any key, we will calculate hash of that key so that it is
		// brought down in the range
		protected int _hash(int key) {
			return (key % this.keyrange);
		}

		public void add(int key) {
			int bucketindex = this._hash(key);
			this.bucketarr[bucketindex].insert(key);

		}

		public void remove(int key) {
			int bucketindex = this._hash(key);
			this.bucketarr[bucketindex].delete(key);
		}

		public boolean contains(int key) {
			int bucketindex = this._hash(key);
			return this.bucketarr[bucketindex].exists(key);

		}
	}

	// this class defines basic functionalities for each individual add, remove,
	// search within the linked list given at an index
	class Bucket {
		LinkedList<Integer> container;

		public Bucket() {
			container = new LinkedList<>();
		}

		// check if already present, else add
		public void insert(int key) {
			int index = this.container.indexOf(key);
			if (index == -1) {
				this.container.addFirst(key);
			}
		}

		public void delete(int key) {
			int ind = this.container.indexOf(key);
			if (ind != -1)
				this.container.remove(ind);
		}

		public boolean exists(int key) {
			return this.container.indexOf(key) != -1;
		}

	}

	/**
	 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
	 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
	 * obj.contains(key);
	 */

}
