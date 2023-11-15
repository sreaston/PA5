

public class TreeTraversals {

	public static void preOrder(BinaryTreeNode node) { // complete this method
		if (node == null) {

			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	public static void inOrder(BinaryTreeNode node) { // complete this method
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	public static void postOrder(BinaryTreeNode node) { // complete this method
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

}
