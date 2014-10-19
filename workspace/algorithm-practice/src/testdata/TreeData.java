package testdata;

import tree.TreeNode;

public class TreeData {

	public static TreeNode generateTreeNode() {
		TreeNode leftLeafNode = new TreeNode("3", null, null);
		TreeNode MiddleLeafNode = new TreeNode("5", null, null);
		TreeNode rightLeafNode = new TreeNode("8", null, null);
		TreeNode leftNode = new TreeNode("2", leftLeafNode, MiddleLeafNode);
		TreeNode rightNode = new TreeNode("6", rightLeafNode, null);
		TreeNode root = new TreeNode("7", leftNode, rightNode);
		return root;
	}
	
}
