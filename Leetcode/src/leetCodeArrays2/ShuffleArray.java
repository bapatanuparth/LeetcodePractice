package leetCodeArrays2;

public class ShuffleArray {

	 public int[] shuffle(int[] nums, int n) {
	     int [] arr= new int[nums.length];
	        int i=0,j=0;
	        for(;n<nums.length;n++){
	            arr[j]=nums[i];
	            i++;j++;
	            arr[j]=nums[n];
	            j++;
	        }
	        
	        return arr;
	    }
}
