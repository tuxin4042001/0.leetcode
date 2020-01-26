package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import _3_breadth_first_search.TreeNode;

/**
 * Use stack and curr pointer to implement inorder traverse
 * 
 * @author terry00
 *
 */
public class _14_inorder_traverse {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);
			curr = curr.right;
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
