package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class _12_binary_tree_path_sum {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
	// 1. Divide conquer + depth first search
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> solution = new ArrayList<Integer>();
    	helper(list, solution, root, target);
    	return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> solution, TreeNode root, int target) {
    	if (root == null) {
    		return;
    	}
    	target -= root.val;
    	if(root.left == null && root.right == null) {
    		if(target == 0) {
    			solution.add(root.val);
    			list.add(new ArrayList<Integer>(solution));
    			solution.remove(solution.size() - 1);
    		}
    		return;
    	}
    	solution.add(root.val);
    	helper(list, solution, root.left, target);
    	helper(list, solution, root.right, target);
    	solution.remove(solution.size() - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
