package leetCodeArrays2;
import java.util.*;

//You are given n cards, with a positive integer printed on the front and back of each card (possibly different). You can flip any number of cards (possibly zero).
//
//After choosing the front and the back of each card, you will pick each card, and if the integer printed on the back of this card is not printed on the front of any other card, then this integer is good.
//
//You are given two integer array fronts and backs where fronts[i] and backs[i] are the integers printer on the front and the back of the ith card respectively.
//
//Return the smallest good and integer after flipping the cards. If there are no good integers, return 0.
//
//Note that a flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.

//Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
//Output: 2
public class CardFlippingGame {

	 public int flipgame(int[] fronts, int[] backs) {
		    
		 //store all bad numbers in 1 set
	        Set<Integer> set= new HashSet<>();
	        for(int i=0;i<fronts.length;i++){
	            if(fronts[i]==backs[i])
	                set.add(fronts[i]);
	        }
	        
	        Set<Integer> good= new HashSet<>();
	        int min=Integer.MAX_VALUE;
	        //store all good numbers in another set
	        for(int i=0;i<backs.length;i++){
	            if(fronts[i]!=backs[i])
	            {
	                good.add(fronts[i]);
	                good.add(backs[i]);
	            }
	        }
	        
	        //check if any bad number is present in good, if yes then remove it
	       for(int notgood:set){
	           if(good.contains(notgood))
	               good.remove(notgood);
	       }
	        
	       //return minimum of the good set
	        for(int i:good)
	            min=Math.min(i,min);
	        if(min==Integer.MAX_VALUE)
	            return 0;
	        
	        return min;
	        
	    
	    }
}
