package _6_two_pointers;

public class _6_kth_largest_element {

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k_index){
        if(start == end){
            return nums[start];
        }
        
        int left = start, right = end, pivot = nums[(start + end)/2];
        while(left <= right){
            while(left <= right && nums[left] > pivot){
                left++;
            }
            
            while(left <= right && nums[right] < pivot){
                right--;
            }
            
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if(start <= right && k_index <= right){
            return quickSelect(nums, start, right, k_index);
        }
        
        if(left <= end && left <= k_index){
            return quickSelect(nums, left, end, k_index);
        }
        
        return nums[k_index];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
