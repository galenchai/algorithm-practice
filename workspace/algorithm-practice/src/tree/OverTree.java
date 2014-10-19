package tree;

import testdata.TreeData;

public class OverTree {

	public static void preOrder(TreeNode treeNode) {
		if (null == treeNode) {
			return;
		} else {
			System.out.print(treeNode.getValue() + ", ");
		}
		preOrder(treeNode.getLeftChild());
		preOrder(treeNode.getRightChild());
	}
	
	public static void inOrder(TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		inOrder(treeNode.getLeftChild());
		System.out.print(treeNode.getValue() + ", ");
		inOrder(treeNode.getRightChild());
	}
	
	public static void postOrder(TreeNode treeNode) {
		if (null == treeNode) {
			return;
		}
		postOrder(treeNode.getLeftChild());
		postOrder(treeNode.getRightChild());
		System.out.print(treeNode.getValue() + ", ");
	}
	
	public static void main(String args[]) {
		preOrder(TreeData.generateTreeNode());
		System.out.println("");
		inOrder(TreeData.generateTreeNode());
		System.out.println("");
		postOrder(TreeData.generateTreeNode());
	}
}
