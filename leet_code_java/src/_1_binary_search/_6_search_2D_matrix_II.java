package _1_binary_search;

public class _6_search_2D_matrix_II {
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int count = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		if(findTarget(matrix[i], target)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    private boolean findTarget(int[] nums, int target) {
    	int start = 0, end = nums.length - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(nums[mid] == target) {
    			return true;
    		}else if(nums[mid] < target) {
    			start = mid;
    		}else {
    			end = mid;
    		}
    	}
    	if(nums[start] == target || nums[end] == target) {
    		return true;
    	}
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
