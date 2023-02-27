package leetcode1;
import java.util.*;

//You are given an integer n.
//
//Each number from 1 to n is grouped according to the sum of its digits.
//
//Return the number of groups that have the largest size.
//
// Input: n = 13
//Output: 4
//Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
//[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
//There are 4 groups with largest size.
public class CountLargestGroup {

	   public int countLargestGroup(int n) {
	        Map<Integer, Integer> map = new HashMap<>();
	        //calc digit sum of each value from 1 to n
	        //stotr in a map with sum , and its frequency of occuerence
	        for(int i=1;i<=n;i++){
	            int sum=digitSum(i);
	            map.compute(sum, (k,v)->(v==null)?1:v+1);
	        }
	       return Collections.frequency(map.values(),Collections.max(map.values()));
	    }
	    
	    public static int digitSum(int n){
	        int sum=0;
	        while(n!=0){
	            sum=sum+n%10;
	            n=n/10;
	        }
	        return sum;
	    }
}
