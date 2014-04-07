
public class BinaryTree extends BinaryTreeNode {
	BinaryTreeNode root;
	
	public BinaryTree() {
		super();
		this.root = this;
		this.parent = null;
	}
	
	
	public void addNode(BinaryTreeNode existingNode, BinaryTreeNode newNode) {
		if (existingNode.value >= newNode.value) {
			if (existingNode.left == null) {
				existingNode.left = newNode;
				newNode.parent = existingNode;
			}
			else
				addNode(existingNode.left, newNode);
		}
		else {
			if (existingNode.right == null) {
				existingNode.right = newNode;
				newNode.parent = existingNode;
			}
			else
				addNode(existingNode.right, newNode);
		}
		
	}
	
	public void printTreeInOrder(BinaryTreeNode root) {
		if (root.left != null)
			printTreeInOrder(root.left);
		System.out.print(root.value + " ");
		if (root.right != null)
			printTreeInOrder(root.right);
	}
	
	public BinaryTreeNode findNode(BinaryTreeNode currentNode, int valueSought) {
		BinaryTreeNode nodeToReturn = null;
		if (currentNode == null)
			return null;
		else if (valueSought < currentNode.value)
			nodeToReturn = findNode(currentNode.left, valueSought);
		else if (valueSought > currentNode.value)
			nodeToReturn = findNode(currentNode.right, valueSought);
		else if (currentNode.value == valueSought)
			nodeToReturn = currentNode;
		return nodeToReturn;
	}
	
	public BinaryTreeNode findNodeIteratively(BinaryTreeNode currentNode, int valueSought) {
		while ( (currentNode != null) && (currentNode.value != valueSought) ) {
			if (valueSought < currentNode.value)
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		}
		if (currentNode == null)
			return null;
		else
			return currentNode;
	}
	
	public BinaryTreeNode findLowestParent(BinaryTreeNode currentNode, int lowerValue, int higherValue) {
		if ( (currentNode.value >= lowerValue) && (currentNode.value < higherValue) )
			return currentNode;
		else if (currentNode.value > higherValue)
			return findLowestParent(currentNode.left, lowerValue, higherValue);
		else if (currentNode.value < lowerValue)
			return findLowestParent(currentNode.right, lowerValue, higherValue);
		else
			return null;
	}
	
	public int findTreeCount(BinaryTreeNode currentNode, int nodeCount) {
		int count = nodeCount;
		if (currentNode.left != null)
			count = findTreeCount(currentNode.left, count);
		if (currentNode.right != null)
			count = findTreeCount(currentNode.right, count);
		return count + 1;
	}
	
	public int findTreeCount(BinaryTreeNode currentNode) {
		if (currentNode == null)
			return 0;
		else
			return 1 + findTreeCount(currentNode.left) + findTreeCount(currentNode.right);
	}
	
	public int findSumOfAllNodes(BinaryTreeNode currentNode) {
		if (currentNode == null)
			return 0;
		else
			return currentNode.value + findSumOfAllNodes(currentNode.left) + findSumOfAllNodes(currentNode.right);
	}
	
	class DepthVariables {
		public int currentDepth;
		public int maxDepth;
		
		public DepthVariables() {
			this.currentDepth = 0;
			this.maxDepth = 0;
		}
		
		public int getCurrentDepth() {
			return this.currentDepth;
		}
		
		public int getMaxDepth() {
			return this.maxDepth;
		}
		
		public void setCurrentDepth(int depth) {
			this.currentDepth = depth;
		}
		
		public void setMaxDepth(int depth) {
			this.maxDepth = depth;
		}
	}
	
	public DepthVariables findTreeDepth(BinaryTreeNode currentNode, DepthVariables depthIn) {
		DepthVariables depthOut = depthIn;
		if (currentNode != null) {
			depthOut.currentDepth += 1;
			if (depthOut.currentDepth > depthOut.maxDepth)
				depthOut.maxDepth = depthOut.currentDepth;
			depthOut = findTreeDepth(currentNode.left, depthOut);
			depthOut = findTreeDepth(currentNode.right, depthOut); 
			depthOut.currentDepth -= 1;
		}
		return depthOut;
	}
	
	public int distanceToAncestor(BinaryTreeNode currentNode, int ancestorValue) {
		if (currentNode.parent.value == ancestorValue) {
			return 1;
		}
		else return 1 + distanceToAncestor(currentNode.parent, ancestorValue);
	}
	
	public int findDistanceBetweenNodes(int lowerValue, int higherValue) {
		BinaryTreeNode lowestAncestor = this.findLowestParent(this.root, lowerValue, higherValue);
		BinaryTreeNode smallerNode = this.findNode(this.root, lowerValue);
		BinaryTreeNode largerNode = this.findNode(this.root, higherValue);
		int distanceFromSmaller = this.distanceToAncestor(smallerNode, lowestAncestor.value);
		int distanceFromLarger = this.distanceToAncestor(largerNode, lowestAncestor.value);
		return distanceFromSmaller + distanceFromLarger;
	}
				
	
	public static void main(String[] args) {
		BinaryTree testTree = new BinaryTree();
		testTree.root.value = 8;
//		System.out.println(testTree.value + "\t" + testTree.left + "\t" + testTree.right + "\t" + testTree.root.value);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		testTree.addNode(testTree.root, node6);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		testTree.addNode(testTree.root, node2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		testTree.addNode(testTree.root, node3);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		testTree.addNode(testTree.root, node7);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		testTree.addNode(testTree.root, node9);
		BinaryTreeNode node12 = new BinaryTreeNode(12);
		testTree.addNode(testTree.root, node12);
		System.out.print("Tree printed in order: ");
//		System.out.println(testTree.value + "\t" + testTree.left + "\t" + testTree.right + "\t" + 
//				testTree.root.value + "\t" + testTree.left.value);
		testTree.printTreeInOrder(testTree.root);
		System.out.println("");
		int numberToFind = 7;
		BinaryTreeNode nodeToFind = testTree.findNode(testTree.root,  numberToFind);
		System.out.println("Parent of node with value " + numberToFind + 
				" is " + nodeToFind.parent.value);
		nodeToFind = testTree.findNodeIteratively(testTree.root,  numberToFind);
		System.out.println("Parent of node with value " + numberToFind + 
				" is " + nodeToFind.parent.value);
		int lowerValue = 3;
		int higherValue = 9;
		nodeToFind = testTree.findLowestParent(testTree.root, lowerValue, higherValue);
		System.out.println("Lowest common ancestor of " + lowerValue + " and " + 
				higherValue + " is " + nodeToFind.value);
		System.out.println("Number of nodes in tree is " + testTree.findTreeCount(testTree.root, 0));
		System.out.println("Number of nodes in tree is " + testTree.findTreeCount(testTree.root));
		System.out.println("Sum of all nodes in tree is " + testTree.findSumOfAllNodes(testTree.root));
		
		DepthVariables treeDepth = testTree.new DepthVariables();
		System.out.println("Depth of tree is " + testTree.findTreeDepth(testTree.root, treeDepth).maxDepth);
		
		int ancestorValue = 8;
		numberToFind = 3;
		nodeToFind = testTree.findNode(testTree.root, numberToFind);
		System.out.println("Distance from node with value " + nodeToFind.value + " to node with value " +
				ancestorValue + " is " + testTree.distanceToAncestor(nodeToFind, ancestorValue)); 
		
		lowerValue = 3;
		higherValue = 12;
		System.out.println("Distance from node with value " + lowerValue + " and node with value " +
				higherValue + " is " + testTree.findDistanceBetweenNodes(lowerValue, higherValue));
	}
	
	
}
