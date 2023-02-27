package leetCodeArrays2;

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

//Input: fruits = [0,1,2,2]
//Output: 3
public class FruitsIntoBasket {

	//method 1 using hashmap
	 public int totalFruit(int[] fruits) {
	        
	        if(fruits.length<=2)return fruits.length;
	        int max=0;
	        Map<Integer, Integer> map= new HashMap<>(); //store the fruits and the index at which the fruit appeared
	        int i=0,j=0;
	        
	        while(j < fruits.length){
	        	
	            if(map.size()<=2){
	                map.put(fruits[j],j++); //if the fruit seen earlier --> update the index, if not add the new fruit with index
	            }
	            
	            if(map.size()>2){ //if map size >2, we need to remove the fruit that has the lowest index because it was seen the earliest
	                int min=fruits.length-1;
	                for(int m:map.values()){
	                    min=Math.min(min,m); //fetch the min index
	                }
	                i=min+1; //move the left to min+1 to ignore the element at min as we are going to discard it
	                map.remove(fruits[min]);
	            }
	            max=Math.max(max,j-i); //choose the max result value
	        } 
	        return max;
	    }
}
