package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1_preorder_traverse {
	// 方法一，利用stack
	// 先将自己放进去，pop()，再依次将self.right和self.left放进去
	public List<Integer> preorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.size() != 0) {
			TreeNode head = stack.pop();
			list.add(head.val);
			if (head.right != null) {
				stack.push(head.right);
			}
			if (head.left != null) {
				stack.push(head.left);
			}
		}
		return list;
	}

	// 方法二，迭代，分治法
	public List<Integer> preorderTraversal2(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		// 分
		List<Integer> left = preorderTraversal2(root.left);
		List<Integer> right = preorderTraversal2(root.right);
		// 治
		list.add(root.val);
		list.addAll(left);
		list.addAll(right);
		return list;
	}

	// 方法三，迭代，traverse
	public List<Integer> preorderTraversal3(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		traverse(root, list);
		return list;
	}

	public void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		traverse(root.left, list);
		traverse(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
