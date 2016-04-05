package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import data_structures.code.dataTypes.BSTNode;
import data_structures.code.dataTypes.BinarySearchTree;

/**
 * Tests for the {@link BinarySearchTree} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class BinarySearchTreeTest
{
	/*
	 * INITIAL DATA
	 */
	private static final List<Integer> data = new ArrayList<Integer>(Arrays.asList(15, 7, 17, 3, 16, 18, 20, 9));
	private static final List<Integer> dataWith8 = new ArrayList<Integer>(Arrays.asList(15, 7, 17, 3, 16, 18, 20, 9, 8));
	private static final List<Integer> dataLeftOnly = new ArrayList<Integer>(Arrays.asList(15, 7, 3, 9));
	private static final List<Integer> dataRightOnly = new ArrayList<Integer>(Arrays.asList(15, 17, 16, 18, 20));

	/*
	 * ORDERS
	 */
	private static final List<Integer> preorder = new ArrayList<Integer>(Arrays.asList(15, 7, 3, 9, 17, 16, 18, 20));
	private static final List<Integer> postorder = new ArrayList<Integer>(Arrays.asList(3, 9, 7, 16, 20, 18, 17, 15));
	private static final List<Integer> inorder = new ArrayList<Integer>(Arrays.asList(3, 7, 9, 15, 16, 17, 18, 20));
	private static final List<Integer> inorderAdded8 = new ArrayList<Integer>(Arrays.asList(3, 7, 8, 9, 15, 16, 17, 18, 20));
	private static final List<Integer> inorderLeftOnly = new ArrayList<Integer>(Arrays.asList(3, 7, 9, 15));
	private static final List<Integer> inorderRightOnly = new ArrayList<Integer>(Arrays.asList(15, 16, 17, 18, 20));
	private static final List<Integer> inorder7Subtree = new ArrayList<Integer>(Arrays.asList(3, 7, 9));

	/*
	 * NEW ORDER AFTER MODIFICATION
	 */
	private static List<Integer> preorderDeletedLeaf = new ArrayList<Integer>();
	private static List<Integer> postorderDeletedBoth = new ArrayList<Integer>();
	private static List<Integer> inorderDeletedBoth2 = new ArrayList<Integer>();
	private static List<Integer> inorderDeletedRoot = new ArrayList<Integer>();
	private static List<Integer> preorderDeletedRight = new ArrayList<Integer>();
	private static List<Integer> inorderDeletedLeft = new ArrayList<Integer>();
	private static List<Integer> inorderLeftOnlyMinusRoot = new ArrayList<Integer>();
	private static List<Integer> inorderRightOnlyMinusRoot = new ArrayList<Integer>();

	/*
	 * VALUES FOR DELETION
	 */
	private static final int deleteLeaf = 9;
	private static final int deleteHasBoth = 17;
	private static final int deleteHasBoth2 = 7;
	private static final int deleteRoot = 15;
	private static final int deleteRightOnly = 18;
	private static final int deleteLeftOnly = 9;

	/*
	 * BINARY SEARCH TREE FOR ORDER TESTS
	 */
	private static BinarySearchTree bst;

	@BeforeClass
	public static void setUp() throws Exception
	{
		preorderDeletedLeaf.addAll(preorder);
		postorderDeletedBoth.addAll(postorder);
		inorderDeletedRoot.addAll(inorder);
		preorderDeletedRight.addAll(preorder);
		inorderDeletedLeft.addAll(inorderAdded8);
		inorderDeletedBoth2.addAll(inorderAdded8);
		inorderLeftOnlyMinusRoot.addAll(inorderLeftOnly);
		inorderRightOnlyMinusRoot.addAll(inorderRightOnly);

		preorderDeletedLeaf.remove(new Integer(deleteLeaf));
		postorderDeletedBoth.remove(new Integer(deleteHasBoth));
		inorderDeletedRoot.remove(new Integer(deleteRoot));
		preorderDeletedRight.remove(new Integer(deleteRightOnly));
		inorderDeletedLeft.remove(new Integer(deleteLeftOnly));
		inorderDeletedBoth2.remove(new Integer(deleteHasBoth2));
		inorderLeftOnlyMinusRoot.remove(new Integer(deleteRoot));
		inorderRightOnlyMinusRoot.remove(new Integer(deleteRoot));

		bst = new BinarySearchTree();
		for (int i = 0; i < data.size(); i++)
		{
			bst.add(data.get(i));
		}
	}

	@Test
	public final void testCreateTree()
	{
		BinarySearchTree newBST = new BinarySearchTree();

		assertEquals(true, newBST.isEmpty());
	}

	@Test
	public final void testCreateBST()
	{
		BinarySearchTree leftBST = new BinarySearchTree();

		assertTrue(leftBST.add(2));

		BinarySearchTree rightBST = new BinarySearchTree();

		assertTrue(rightBST.add(3));

		BSTNode newBSTNode = new BSTNode(1, leftBST, rightBST);

		assertEquals(leftBST, newBSTNode.getLeft());
		assertEquals(rightBST, newBSTNode.getRight());
	}

	@Test
	public final void testCreateTreeHeight()
	{
		System.out.println("---- testCreateTreeHeight() START ----");

		BinarySearchTree newBST = new BinarySearchTree();

		System.out.println("+ 15");

		assertTrue(newBST.add(15));

		System.out.println("+ 17");

		assertTrue(newBST.add(17));

		System.out.println("+ 16");

		assertTrue(newBST.add(16));

		System.out.println("+ 18");

		assertTrue(newBST.add(18));

		System.out.println("+ 20");

		assertTrue(newBST.add(20));

		System.out.println("---- testCreateTreeHeight() END ----");

		assertEquals(3, newBST.getHeight());
	}

	@Test
	public final void testClear()
	{
		BinarySearchTree newBST = new BinarySearchTree();

		assertTrue(newBST.add(1));
		assertEquals(false, newBST.isEmpty());

		newBST.clear();

		assertEquals(true, newBST.isEmpty());
	}

	@Test
	public final void testRemoveEmpty()
	{
		BinarySearchTree newBST = new BinarySearchTree();

		assertEquals(false, newBST.remove(1));
	}

	@Test
	public final void testRemoveNonExistent()
	{
		BinarySearchTree newBST = new BinarySearchTree();

		assertTrue(newBST.add(10));
		assertFalse(newBST.remove(1));
		assertFalse(newBST.remove(20));
	}

	@Test
	public final void testContains()
	{
		BinarySearchTree sub = bst.contains(7);

		assertEquals(inorder7Subtree, sub.getInOrder());
	}

	@Test
	public final void testContains2()
	{
		BinarySearchTree sub = bst.contains(21);

		assertEquals(null, sub);
	}

	@Test
	public final void testContains_Root()
	{
		BinarySearchTree sub = bst.contains(15);

		assertEquals(inorder, sub.getInOrder());
	}

	@Test
	public final void testContains_Invalid()
	{
		BinarySearchTree sub = bst.contains(-123);

		assertEquals(null, sub);
	}

	@Test
	public final void testContains_Leaf()
	{
		BinarySearchTree sub = bst.contains(3);

		assertEquals(new ArrayList<Integer>(Arrays.asList(3)), sub.getInOrder());
	}

	@Test
	public final void testGetHeight()
	{
		assertEquals(3, bst.getHeight());
	}

	@Test
	public final void testGetHeight_Empty()
	{
		BinarySearchTree newTree = new BinarySearchTree();

		assertEquals(-1, newTree.getHeight());
	}

	@Test
	public final void testGetHeight_Leaf()
	{
		BinarySearchTree sub = bst.contains(3);

		assertEquals(0, sub.getHeight());
	}

	@Test
	public final void testGetHeight_1()
	{
		BinarySearchTree sub = bst.contains(7);

		assertEquals(1, sub.getHeight());
	}

	@Test
	public final void testGetHeight_2()
	{
		BinarySearchTree sub = bst.contains(17);

		assertEquals(bst.getHeight() - 1, sub.getHeight());
	}

	/*
	 * -------- ORDER TESTS --------
	 */

	@Test
	public final void testOrder_PreOrder()
	{
		List<Integer> order = bst.getPreOrder();
		System.out.println("Pre-order: " + order);

		assertNotEquals(data, order);
		assertEquals(preorder, order);

	}

	@Test
	public final void testOrder_PostOrder()
	{
		List<Integer> order = bst.getPostOrder();
		System.out.println("Post-order: " + order);

		assertNotEquals(data, order);
		assertEquals(postorder, order);
	}

	@Test
	public final void testOrder_InOrder()
	{
		List<Integer> order = bst.getInOrder();
		System.out.println("In-order: " + order);

		assertNotEquals(data, order);
		assertEquals(inorder, order);
	}

	@Test
	public final void testOrder_PreOrder_Empty()
	{
		final BinarySearchTree tree = new BinarySearchTree();

		assertEquals(new ArrayList<Integer>(), tree.getPreOrder());
	}

	@Test
	public final void testOrder_PostOrder_Empty()
	{
		final BinarySearchTree tree = new BinarySearchTree();

		assertEquals(new ArrayList<Integer>(), tree.getPostOrder());
	}

	@Test
	public final void testOrder_InOrder_Empty()
	{
		final BinarySearchTree tree = new BinarySearchTree();

		assertEquals(new ArrayList<Integer>(), tree.getInOrder());
	}

	/*
	 * -------- DELETE TESTS --------
	 */

	@Test
	public final void testDelete_Leaf()
	{
		BinarySearchTree bstDeleteLeaf = new BinarySearchTree();

		for (int i = 0; i < data.size(); i++)
		{
			assertTrue(bstDeleteLeaf.add(data.get(i)));
		}

		assertTrue(bstDeleteLeaf.remove(deleteLeaf));

		List<Integer> order = bstDeleteLeaf.getPreOrder();
		System.out.println("Pre-order deleted leaf: " + order);

		assertEquals(preorderDeletedLeaf, order);
	}

	@Test
	public final void testDelete_HasBoth()
	{
		BinarySearchTree bstDeleteBoth = new BinarySearchTree();

		for (int i = 0; i < data.size(); i++)
		{
			assertTrue(bstDeleteBoth.add(data.get(i)));
		}

		assertTrue(bstDeleteBoth.remove(deleteHasBoth));

		List<Integer> order = bstDeleteBoth.getPostOrder();
		System.out.println("Post-order deleted both: " + order);

		assertEquals(postorderDeletedBoth, order);
	}

	@Test
	public final void testDelete_Root()
	{
		BinarySearchTree bstDeleteRoot = new BinarySearchTree();

		for (int i = 0; i < data.size(); i++)
		{
			assertTrue(bstDeleteRoot.add(data.get(i)));
		}

		assertTrue(bstDeleteRoot.remove(deleteRoot));

		List<Integer> order = bstDeleteRoot.getInOrder();
		System.out.println("In-order deleted root: " + order);

		assertEquals(inorderDeletedRoot, order);
	}

	@Test
	public final void testDelete_Right()
	{
		BinarySearchTree bstDeleteRight = new BinarySearchTree();

		for (int i = 0; i < data.size(); i++)
		{
			assertTrue(bstDeleteRight.add(data.get(i)));
		}

		assertTrue(bstDeleteRight.remove(deleteRightOnly));

		List<Integer> order = bstDeleteRight.getPreOrder();
		System.out.println("Pre-order deleted right: " + order);

		assertEquals(preorderDeletedRight, order);
	}

	@Test
	public final void testDelete_Left()
	{
		BinarySearchTree bstDeleteLeft = new BinarySearchTree();

		for (int i = 0; i < dataWith8.size(); i++)
		{
			assertTrue(bstDeleteLeft.add(dataWith8.get(i)));
		}

		assertEquals(inorderAdded8, bstDeleteLeft.getInOrder());
		assertTrue(bstDeleteLeft.remove(deleteLeftOnly));

		List<Integer> order = bstDeleteLeft.getInOrder();
		System.out.println("In-order deleted left: " + order);

		assertEquals(inorderDeletedLeft, order);
	}

	@Test
	public final void testDelete_HasBoth2()
	{
		BinarySearchTree bstDeleteBoth = new BinarySearchTree();

		for (int i = 0; i < dataWith8.size(); i++)
		{
			assertTrue(bstDeleteBoth.add(dataWith8.get(i)));
		}

		assertEquals(inorderAdded8, bstDeleteBoth.getInOrder());
		assertTrue(bstDeleteBoth.remove(deleteHasBoth2));

		List<Integer> order = bstDeleteBoth.getInOrder();
		System.out.println("In-order deleted has both 2: " + order);

		assertEquals(inorderDeletedBoth2, order);
	}

	@Test
	public final void testDelete_RootOnly()
	{
		BinarySearchTree bstRoot = new BinarySearchTree();

		assertTrue(bstRoot.add(1));
		assertFalse(bstRoot.isEmpty());
		assertTrue(bstRoot.remove(1));
	}

	@Test
	public final void testDelete_LeftOnly()
	{
		BinarySearchTree bstLeftOnly = new BinarySearchTree();

		for (int i = 0; i < dataLeftOnly.size(); i++)
		{
			assertTrue(bstLeftOnly.add(dataLeftOnly.get(i)));
		}

		assertTrue(bstLeftOnly.remove(deleteRoot));

		List<Integer> order = bstLeftOnly.getInOrder();
		System.out.println("In-order left only deleted root: " + order);

		assertEquals(inorderLeftOnlyMinusRoot, order);
	}

	@Test
	public final void testDelete_LeftOnly2()
	{
		BinarySearchTree bstLeftOnly = new BinarySearchTree();

		for (int i = 0; i < dataLeftOnly.size(); i++)
		{
			assertTrue(bstLeftOnly.add(dataLeftOnly.get(i)));
		}

		assertTrue(bstLeftOnly.remove(deleteRoot));

		List<Integer> order = bstLeftOnly.getInOrder();
		System.out.println("In-order left only deleted root: " + order);

		assertEquals(inorderLeftOnlyMinusRoot, order);
	}

	@Test
	public final void testDelete_RightOnly()
	{
		BinarySearchTree bstRightOnly = new BinarySearchTree();

		for (int i = 0; i < dataRightOnly.size(); i++)
		{
			assertTrue(bstRightOnly.add(dataRightOnly.get(i)));
		}

		assertTrue(bstRightOnly.remove(deleteRoot));

		List<Integer> order = bstRightOnly.getInOrder();
		System.out.println("In-order right only deleted root: " + order);

		assertEquals(inorderRightOnlyMinusRoot, order);
	}
}
