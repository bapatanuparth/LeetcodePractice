package leetCodeArrays;
import java.util.*;

public class IntersectionOfArrays2 {

	//my solution using 2 hashmaps
	public int[] intersectMySolution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map= new HashMap<>();
        Map<Integer, Integer> map2=new HashMap<>();
        
        for(int i:nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            map2.put(i, map2.getOrDefault(i,0)+1);
        }

        List<Integer> list=new ArrayList<>();
        for(int i:map.keySet()){
            if(map2.containsKey(i)){
                int temp=Math.min(map.get(i), map2.get(i));
                for(int k=0;k<temp;k++)list.add(i);
            }
        }
        int [] res=new int[list.size()];
        int j=0;
        for(int i:list){
            res[j]=i;
            j++;
        }
        return res;
    }
	
	
	//solution 2 -- only one hashmap
	 public int[] intersect(int[] nums1, int[] nums2) {
	        
	        if(nums1.length > nums2.length) {
	            return intersect(nums2, nums1);
	        }        
	        
	        Map<Integer, Integer> hashmap = new HashMap();  
	        for (int num : nums1){
	            if (!hashmap.containsKey(num)) hashmap.put(num,1);
	            else hashmap.put(num,hashmap.get(num)+1);
	        }
	        int k = 0;
	        for (int num : nums2) {
	            if (hashmap.containsKey(num) && hashmap.get(num)>0){
	                nums1[k++] = num;
	                //subtract one each time the element is present and add it in the 
	                //nums1 array which will be used for result
	                hashmap.put(num,hashmap.get(num)-1);
	            }
	        }
	        return Arrays.copyOfRange(nums1, 0, k);
	    }
	 
	 //if 2 arrays are already sorted
	 //solution can be optimized without using any extra space
	  public int[] intersectSorted(int[] nums1, int[] nums2) {
	        
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        ArrayList<Integer> list=new ArrayList();
	        int m=nums1.length-1,n=nums2.length-1;
	        while(m>-1 && n>-1)
	        {
	            if(nums1[m]<nums2[n])
	            {n--;}
	            else if(nums1[m]>nums2[n])
	            {m--;}
	            else
	            {
	                list.add(nums1[m--]);
	                n--;
	            }
	        }
	        int ttt=list.size();
	        int arr[]=new int[ttt];
	        for(int k=0;k<ttt;k++)
	            arr[k]=list.get(k);
	        return arr;
	    }
}
