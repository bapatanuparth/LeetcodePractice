package leetCodeArrays2;
import java.util.*;

//Given an array of integers arr, replace each element with its rank.
//
//The rank represents how large the element is. The rank has the following rules:
//
//Rank is an integer starting from 1.
//The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//Rank should be as small as possible.

//Input: arr = [40,10,20,30]
//Output: [4,1,2,3]

//Input: arr = [37,12,28,9,100,56,80,5,12]
//Output: [5,3,4,2,8,6,7,1,3]
public class RankTransformArray {

	
	public static int[] arrayRankTransformEff(int[] arr) 
	{
	        int[] ans = new int[arr.length];
	        for(int i = 0; i < arr.length; i++)
	        {
	            ans[i] = arr[i];
	        }

	        Arrays.sort(ans);

	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i : ans)
	        {
	            if(!map.containsKey(i))
	            {
	                map.put(i, map.size() + 1);
	            }
	        }

	        for(int i = 0 ; i < arr.length ; i++)
	        {
	            arr[i] = map.get(arr[i]);
	        }
	        return arr;
	 }

}
