package _1_binary_search;

public class _5_find_minimum_rotated_sorted_array {
    public int findMin(int[] nums) {
        // write your code here
    	if(nums == null || nums.length == 0) {
    		return -1;
    	}
    	int start = 0, end = nums.length - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(nums[mid] > nums[end]) {
    			start = mid;
    		}else {
    			end = mid;
    		}
    	}
    	if(nums[start] < nums[end]) {
    		return nums[start];
    	}
    	return nums[end];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 4, 5, 6, 7, 0, 1, 2 };
		_5_find_minimum_rotated_sorted_array find = new _5_find_minimum_rotated_sorted_array();
		System.out.println(find.findMin(nums));
	}
}
