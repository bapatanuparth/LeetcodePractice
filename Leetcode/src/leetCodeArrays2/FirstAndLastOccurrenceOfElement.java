package leetCodeArrays2;


//find first and last occurrence of an element in sorted array
public class FirstAndLastOccurrenceOfElement {

	
	//O{log n) solution using binary search
	  public int[] searchRange(int[] nums, int target) {
	        int mid= nums.length/2;
	        int left=0, right=nums.length-1;
	        //test case
	        if(nums.length==0)
	            return new int[]{-1,-1};
	        
	        int min=Integer.MAX_VALUE, max=Integer.MAX_VALUE;
	        
	        //code to find the first occurrence
	        while(left<=right){
	            mid=(left+right)/2;
	            if(nums[mid]==target){
	                if(mid!=0 && nums[mid-1]==target)
	                    right=mid-1;
	                else {min=mid;break;}
	            }
	            else if(nums[mid]<target)
	                left=mid+1;
	            else 
	                right=mid-1;
	        }
	        
	      
	        //code to find the last occurrence
	        left=0;right=nums.length-1;
	        mid=nums.length/2;
	        
	        while(left<=right){
	            mid=(left+right)/2;
	            
	            if(nums[mid]==target){
	            	
	                if(mid!=(nums.length-1) && nums[mid+1]==target)	                	 
	                    left=mid+1;
	                else {max=mid;break;}
	            }
	            else if(nums[mid]<target)
	                left=mid+1;
	            else 
	                right=mid-1;
	        }
	        
	        //if target not found
	        if(min==Integer.MAX_VALUE)
	            return new int[]{-1,-1};
	       
	        return new int[]{min,max};  
	    }
}
