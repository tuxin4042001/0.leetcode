package _2_binary_tree;

public class _19_delete_node_in_binary_search_tree {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			TreeNode minNode = findMinNode(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	private TreeNode findMinNode(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
