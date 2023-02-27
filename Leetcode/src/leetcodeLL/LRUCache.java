package leetcodeLL;

import java.util.HashMap;
import java.util.Map;

//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.

class DNode {
	int key;
	int val;
	DNode next;
	DNode prev;

}

//keep a head and tail node outside of the cache and do all the cache activities in between head and tail to avoid null pointers

public class LRUCache {

	// add node in front of head
	void addNode(DNode node) {
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	// remove any node
	void removeNode(DNode node) {
		DNode prev = node.prev;
		DNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	// move the accessed element to the beginning, after head
	void moveToHead(DNode node) {
		removeNode(node);
		addNode(node);
	}

	// if size>capacity, remove from tail as this is the least accessed element
	DNode popTail() {
		DNode res = tail.prev;
		removeNode(res);
		return res;
	}

	// use a hashmap to store the key value pair of the key and node
	Map<Integer, DNode> map = new HashMap<>();
	int cap;
	DNode head, tail;
	int size;

	public LRUCache(int capacity) {
		this.size = 0;
		this.cap = capacity;
		head = new DNode();
		tail = new DNode();
		map = new HashMap<>();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DNode node = map.get(key);
		if (node == null)
			return -1;

		moveToHead(node);

		return node.val;
	}

	public void put(int key, int val) {

		DNode node = map.get(key);

		if (node == null) {
			DNode newnode = new DNode();
			newnode.key = key;
			newnode.val = val;

			map.put(key, newnode);
			addNode(newnode);
			size++;

			if (size > cap) {
				DNode tail = popTail();
				map.remove(tail.key);
				size--;
			}
		} else {
			node.val = val;
			moveToHead(node);
		}
	}

}
