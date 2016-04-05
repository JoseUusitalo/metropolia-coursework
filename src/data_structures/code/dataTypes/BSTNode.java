package data_structures.code.dataTypes;

/**
 * A binary search tree node.
 *
 * @author Jose Uusitalo
 */
public class BSTNode
{
	/**
	 * Stored data.
	 */
	private int data;

	/**
	 * The left binary search tree of this node.
	 */
	private BinarySearchTree left;

	/**
	 * The right binary search tree of this node.
	 */
	private BinarySearchTree right;

	/**
	 * The height of this node.
	 */
	private int height;

	/**
	 * @param value
	 */
	public BSTNode(final int value)
	{
		data = value;
	}

	/**
	 * @param value
	 * @param left
	 * @param right
	 */
	public BSTNode(final int value, final BinarySearchTree leftBST, final BinarySearchTree rightBST)
	{
		this.data = value;
		this.left = leftBST;
		this.right = rightBST;
	}

	/**
	 * Gets the height of this node in the parent tree.
	 *
	 * @return the height of this node
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Gets the data in this node.
	 *
	 * @return data
	 */
	public int getData()
	{
		return data;
	}

	/**
	 * Gets the left child binary tree of this node.
	 *
	 * @return the left binary search tree
	 */
	public BinarySearchTree getLeft()
	{
		return left;
	}

	/**
	 * Gets the right child binary tree of this node.
	 *
	 * @return the right binary search tree
	 */
	public BinarySearchTree getRight()
	{
		return right;
	}

	/**
	 * Sets the left child binary tree of this node.
	 *
	 * @param tree the left binary search tree
	 */
	public void setLeft(final BinarySearchTree bst)
	{
		left = bst;
	}

	/**
	 * Sets the right child binary tree of this node.
	 *
	 * @param tree the right binary search tree
	 */
	public void setRight(final BinarySearchTree bst)
	{
		right = bst;
	}

	/**
	 * Sets the height of this node to be the height of the left or right child + 1 unless the current height is greater
	 * than the height of the child tree.
	 *
	 * @param leftChild if <code>true</code> modify the height of this node according to the heigt of the left child
	 * tree, otherwise use the right tree
	 */
	public void modHeight(final boolean leftChild)
	{
		int newHeight = 0;

		if (leftChild)
			newHeight = left.getHeight() + 1;
		else
			newHeight = right.getHeight() + 1;

		if (height < newHeight)
			height = newHeight;
	}
}
