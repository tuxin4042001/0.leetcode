package _2_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class _5_bianry_tree_path {
	public List<String> binaryTreePaths(TreeNode root) {
		// write your code here
		List<String> list = new ArrayList<String>();
		if (root == null) {
			return list;
		}
		List<String> left = binaryTreePaths(root.left);
		List<String> right = binaryTreePaths(root.right);
		for (String elem : left) {
			list.add(root.val + "->" + elem);
		}
		for (String elem : right) {
			list.add(root.val + "->" + elem);
		}
		if (list.size() == 0) {
			list.add("" + root.val);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
