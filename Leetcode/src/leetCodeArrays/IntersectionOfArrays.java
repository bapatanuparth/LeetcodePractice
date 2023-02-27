package leetCodeArrays;

import java.util.HashSet;
import java.util.Set;

//return common elements of both arrays, should be unique
public class IntersectionOfArrays {

	 public int[] intersection(int[] nums1, int[] nums2) {
	        Set<Integer> set=new HashSet<>();
	        for(int i:nums1){
	            set.add(i);
	        }
	        Set<Integer> ls= new HashSet<>();
	        for(int i:nums2){
	            if(set.contains(i))ls.add(i);
	        }
	        int [] res= new int[ls.size()];
	        int j=0;
	        for(Integer i: ls)
	        {
	            res[j]=i;
	            j++;
	        }
	        return res;
	    }
}
