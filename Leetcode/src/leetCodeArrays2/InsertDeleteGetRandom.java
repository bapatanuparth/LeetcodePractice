package leetCodeArrays2;
import java.util.*;
//Implement the RandomizedSet class:
//
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.



public class InsertDeleteGetRandom {
	class RandomizedSet {
	   ArrayList<Integer> list;
	   Map<Integer, Integer> map;
	    
	    public RandomizedSet() {
	        map= new HashMap<>();
	        list= new ArrayList<>();
	    }
	    
	    public boolean insert(int val) {
	        if(map.containsKey(val))
	            return false;
	        
	        map.put(val, list.size());
	        list.add(val);
	        return true;
	    }
	    
	    //key function --> remove element from list in O(1)
	    //get index of element to be removed
	    //replace it with value of the last element, update the new index for the last element in map
	    //then remove the last element
	    public boolean remove(int val) {
	        if(!map.containsKey(val))
	            return false;
	        
	        int lastIndex= list.size()-1;
	        int lastElement= list.get(lastIndex);
	        
	        int indexToRemove= map.get(val);
	        
	        list.set(indexToRemove, lastElement);
	        
	        list.remove(lastIndex);
	        
	        map.replace(lastElement, indexToRemove);
	        map.remove(val);
	        return true;
	        
	        
	    }
	    
	    public int getRandom() {
	        int random= new Random().nextInt(list.size());
	        return list.get(random);
	        
	    }
	}
}
