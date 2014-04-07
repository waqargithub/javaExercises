public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int valueIn) {
		this.value = valueIn;
		this.left = null;
		this.right = null;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int valueIn) {
		this.value = valueIn;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public TreeNode getRight() {
		return this.right;
	}
	
	public void setLeft(TreeNode leftIn) {
		this.left = leftIn;
	}
	
	public void setRight(TreeNode rightIn) {
		this.right = rightIn;
	}
}