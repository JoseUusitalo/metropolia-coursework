package data_structures.code.dataTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary search tree implementation.
 *
 * @author Jose Uusitalo
 */
public class BinarySearchTree
{
	/**
	 * The root {@link BSTNode} of this binary search tree.
	 */
	private BSTNode root;

	public BinarySearchTree()
	{
	}

	/**
	 * @param rootValue
	 */
	public BinarySearchTree(final int rootValue)
	{
		root = new BSTNode(rootValue);
	}

	/*
	 * -------- GETTERS --------
	 */

	/**
	 * Checks if this binary search tree is empty.
	 *
	 * @return <code>true</code> if this binary search tree is empty
	 */
	public boolean isEmpty()
	{
		return root == null;
	}

	/**
	 * Gets the height of this tree.
	 *
	 * @return the height of this tree or <code>-1</code> if this tree is empty
	 */
	public int getHeight()
	{
		if (root == null)
			return -1;
		return root.getHeight();
	}

	/**
	 * Gets the data in this binary search tree pre-ordered.
	 *
	 * @return a pre-ordered List of integers
	 */
	public List<Integer> getPreOrder()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root != null)
		{
			list.add(root.getData());

			// Free space on the left?
			if (root.getLeft() != null)
				list.addAll(root.getLeft().getPreOrder());

			// Free space on the right?
			if (root.getRight() != null)
				list.addAll(root.getRight().getPreOrder());
		}

		return list;
	}

	/**
	 * Gets the data in this binary search tree post-ordered.
	 *
	 * @return a post-ordered List of integers
	 */
	public List<Integer> getPostOrder()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root != null)
		{
			// Free space on the left?
			if (root.getLeft() != null)
				list.addAll(root.getLeft().getPostOrder());

			// Free space on the right?
			if (root.getRight() != null)
				list.addAll(root.getRight().getPostOrder());

			list.add(root.getData());
		}
		return list;
	}

	/**
	 * Gets the data in this binary search tree in-ordered.
	 *
	 * @return an in-ordered List of integers
	 */
	public List<Integer> getInOrder()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root != null)
		{
			// Free space on the left?
			if (root.getLeft() != null)
				list.addAll(root.getLeft().getInOrder());

			list.add(root.getData());

			// Free space on the right?
			if (root.getRight() != null)
				list.addAll(root.getRight().getInOrder());
		}

		return list;
	}

	/**
	 * Checks if the given is present in the binary search tree.
	 *
	 * @param value value to search for
	 * @return the binary search tree that begins at the given value or <code>null</code> if value is not present in the
	 * tree
	 */
	public BinarySearchTree contains(final int value)
	{
		if (value < root.getData())
		{
			if (root.getLeft() != null)
				return root.getLeft().contains(value);
			return null;
		}
		else if (value > root.getData())
		{
			if (root.getRight() != null)
				return root.getRight().contains(value);
			return null;
		}
		return this;
	}

	/*
	 * -------- SETTERS --------
	 */

	/**
	 * Sets the left child of this binary search tree.
	 *
	 * @param tree binary search tree to set as child
	 */
	public void setLeft(final BinarySearchTree bst)
	{
		root.setLeft(bst);
	}

	/**
	 * Sets the right child of this binary search tree.
	 *
	 * @param tree binary search tree to set as child
	 */
	public void setRight(final BinarySearchTree bst)
	{
		root.setRight(bst);
	}

	/**
	 * Removes all nodes from this binary search tree.
	 */
	public void clear()
	{
		root = null;
	}

	/**
	 * Adds the given data to this binary search tree into the correct position.
	 *
	 * @param data data to add
	 */
	public boolean add(final int data)
	{
		boolean recursiveResult = false;

		if (root == null)
		{
			// System.out.println("[ ] Root is null, new node: " + data);
			root = new BSTNode(data);
			// System.out.println("[ ] Added new node.");
			return true;
		}
		// Is the data less than or equal to the current node?
		else if (data < root.getData())
		{
			// System.out.println(data + " <= " + root.getData());
			// Is there space on the left?
			if (root.getLeft() == null)
			{
				// System.out.println("[" + root.getData() + " : " + getHeight() + "] Add left: " + data);
				// Add the data to the left of this node.
				root.setLeft(new BinarySearchTree(data));
				// System.out.println("[" + root.getData() + " : " + getHeight() + "] Mod height");
				root.modHeight(true);
				return true;
			}

			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Go left");
			recursiveResult = root.getLeft().add(data); // Go deeper into the left.
			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Mod height");
			root.modHeight(true);
			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Gone left.");
		}
		else if (data > root.getData())
		{
			// System.out.println(data + " > " + root.getData());
			// Is there space on the right?
			if (root.getRight() == null)
			{
				// System.out.println("[" + root.getData() + " : " + getHeight() + "] Add right: " + data);
				// Add the data to the left of this node.
				root.setRight(new BinarySearchTree(data));
				// System.out.println("[" + root.getData() + " : " + getHeight() + "] Mod height");
				root.modHeight(false);
				return true;
			}

			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Go right");
			recursiveResult = root.getRight().add(data); // Go deeper into the right.
			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Mod height");
			root.modHeight(false);
			// System.out.println("[" + root.getData() + " : " + getHeight() + "] Gone right.");
		}

		// System.out.println("[" + root.getData() + " : " + getHeight() + "] Done with add.");
		return recursiveResult;
	}

	/**
	 * Removes the given data from the binary search tree.
	 *
	 * @param data data to remove
	 * @param parent the parent node
	 * @return <code>true</code> if data existed in the tree and was removed, <code>false</code> if data does not exist
	 * in the tree
	 */
	private boolean remove(final int data, final BinarySearchTree parentTree)
	{
		// Tree is empty.
		if (root == null)
			return false;

		if (data < root.getData())
		{
			// System.out.println(data + " < " + root.getData());

			// Left tree does not exist? Value is not in the tree.
			if (root.getLeft() == null)
				return false;

			// Else go deeper into the left.
			root.getLeft().remove(data, this);
		}
		else if (data > root.getData())
		{
			// System.out.println(data + " > " + root.getData());

			// Right tree does not exist? Value is not in the tree.
			if (root.getRight() == null)
				return false;

			// Else go deeper into the right.
			root.getRight().remove(data, this);
		}
		else
		{
			/*
			 * data == current root
			 *
			 * if (parentTree != null)
			 * System.out.println(data + " == " + root.getData() + " parent " + parentTree.root.getData());
			 * else
			 * System.out.println(data + " == root");
			 */

			// No child trees.
			if (root.getLeft() == null && root.getRight() == null)
			{
				// Just delete this node.
				if (parentTree == null)
					root = null;
				else if (data < parentTree.root.getData())
					parentTree.setLeft(null);
				else
					parentTree.setRight(null);

				return true;
			}
			else if (root.getLeft() != null && root.getRight() == null)
			{
				// If only the left child tree exists.

				// This is the root.
				if (parentTree == null)
					root = root.getLeft().root; // Make the left tree of this node the new root of the tree.
				// This is not the root. Move the left child tree of this node to be a child of the parent.
				else if (data < parentTree.root.getData())
					parentTree.setLeft(root.getLeft());
				else
					parentTree.setRight(root.getLeft());

				return true;
			}
			else if (root.getRight() != null && root.getLeft() == null)
			{
				// If only the right child tree exists.

				// This is the root.
				if (parentTree == null)
					root = root.getRight().root; // Make the left tree of this node the new root of the tree.
				// Move the right child tree of this node to be a child of the parent.
				else if (data < parentTree.root.getData())
					parentTree.setLeft(root.getRight());
				else
					parentTree.setRight(root.getRight());

				return true;
			}
			else
			{
				// Both child trees exist.

				// Find the next smallest root node on the right side of this node.
				BinarySearchTree nextSmallestNodeParent = nextSmallestNodeParent(root.getRight());

				// The right child is the next smallest value.
				if (nextSmallestNodeParent == null)
				{
					// System.out.println("after " + root.getData() + " smallest " + root.getRight().root.getData());

					// Move the left child of this node to be the left child of the next smallest value.
					root.getRight().setLeft(root.getLeft());

					// FIXME: WILL CRASH IF ROOT HAS NO RIGH CHILD.

					// Move the right child tree of this node to be a child of the parent.
					if (data < parentTree.root.getData())
						parentTree.setLeft(root.getRight());
					else
						parentTree.setRight(root.getRight());

					// References to this node have been removed and it will be garbage collected.
					return true;
				}

				// System.out.println("after " + root.getData() + " smallest " +
				// nextSmallestNodeParent.root.getLeft().root.getData());

				// Move the left child tree of this node to be the left child of the next smallest value.
				nextSmallestNodeParent.root.getLeft().setLeft(root.getLeft());

				// Move the right child tree of this node to be the right child of the next smallest value.
				nextSmallestNodeParent.root.getLeft().setRight(root.getRight());

				// Set the next smallest value to be the root of the tree.
				root = nextSmallestNodeParent.root.getLeft().root;

				// References to the original root are lost and will be garbage collected.

				// Remove the connection from the next smallest parent to the next smallest value.
				nextSmallestNodeParent.setLeft(null);

				return true;
			}
		}
		return true;
	}

	/**
	 * Finds the parent of the next smallest value in the tree starting from the given parent tree.
	 *
	 * @param parent parent tree to start search from
	 * @return the parent of the next smallest node or <code>null</code> if the given parent itself is the next smallest
	 * value
	 */
	private BinarySearchTree nextSmallestNodeParent(final BinarySearchTree parent)
	{
		// If we can't go further left the parent itself is the smallest value.
		if (parent.root.getLeft() == null)
			return null;
		else if (parent.root.getLeft().root.getLeft() == null)
			// If the left child's left child does not exist, this is the parent of the smallest value.
			return parent;

		// Otherwise go deeper left.
		return nextSmallestNodeParent(parent.root.getLeft());
	}

	/**
	 * Removes the given data from the binary search tree.
	 *
	 * @param data data to remove
	 * @return <code>true</code> if data existed in the tree and was removed, <code>false</code> if data does not exist
	 * in the tree
	 */
	public boolean remove(final int data)
	{
		return remove(data, null);
	}
}
