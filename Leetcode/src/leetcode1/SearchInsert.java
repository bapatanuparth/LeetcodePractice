package leetcode1;

public class SearchInsert {

	public static void main(String[] args) {
		searchInsert(new int[] {0,1,3,4,5,5,6},2);
	}
	public static void searchInsert(int[] nums, int target) {
	    System.out.println(binarySearch(nums, 0, nums.length-1, target));
    }
    
     public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 

            return binarySearch(arr, mid + 1, r, x);
        }
         else 
             return l;
}
}

