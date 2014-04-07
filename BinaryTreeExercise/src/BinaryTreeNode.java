
public class BinaryTreeNode extends TreeNode {
	BinaryTreeNode parent;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode() {
		super();
		this.parent = null;
	}
	
	public BinaryTreeNode(int valueIn) {
		super();
		this.parent = null;
		this.value = valueIn;
	}
	
	public BinaryTreeNode getParent() {
		return this.parent;
	}
	
	public void setParent(BinaryTreeNode node) {
		this.parent = node;
	}

}
