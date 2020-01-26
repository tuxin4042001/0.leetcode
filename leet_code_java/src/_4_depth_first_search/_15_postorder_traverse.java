package _4_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import _3_breadth_first_search.TreeNode;

/**
 * Use stack, list add first method to implement postorder traverse
 * 
 * @author terry00
 *
 */
public class _15_postorder_traverse {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode head = stack.pop();
			list.add(0, head.val);
			if (head.left != null) {
				stack.push(head.left);
			}
			if (head.right != null) {
				stack.push(head.right);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
