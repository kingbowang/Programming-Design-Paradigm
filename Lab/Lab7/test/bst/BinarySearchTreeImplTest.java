package bst;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests the binary search tree implementation.
 *
 * @author Pengbo Wang
 */
public class BinarySearchTreeImplTest {

  public BinarySearchTree<Integer> tree1;
  public BinarySearchTree<Integer> tree2;

  @Before
  public void setUp() {
    tree1 = new BinarySearchTreeImpl<>();
    tree1.add(4);
    tree1.add(6);
    tree1.add(2);
    tree1.add(1);
    tree1.add(3);
    tree1.add(5);
    tree1.add(7);
    tree2 = new BinarySearchTreeImpl<>();
    tree2.add(6);
    tree2.add(4);
    tree2.add(2);
    tree2.add(1);
    tree2.add(3);
    tree2.add(5);
    tree2.add(7);
    tree2.add(8);
  }

  /**
   * A test that shows that a BST created with the default constructor creates an empty tree.
   */
  @Test
  public void testEmptyTree() {
    tree1 = new BinarySearchTreeImpl<>();
    BinarySearchTree<String> emptyTree = new BinarySearchTreeImpl<>();
    assertEquals(0, tree1.size());
    assertEquals(0, emptyTree.size());
    assertEquals("[]", tree1.toString());
    assertEquals("[]", emptyTree.toString());
  }

  /**
   * A test that verifies that toString works correctly with an empty tree.
   */
  @Test
  public void testToStringEmptyTree() {
    BinarySearchTree<String> emptyTree = new BinarySearchTreeImpl<>();
    assertEquals("[]", emptyTree.toString());
  }

  /**
   * A test that verifies that add correctly inserts an object into the tree when the tree is empty.
   */
  @Test
  public void testAddEmptyTree() {
    BinarySearchTree<String> tree = new BinarySearchTreeImpl<>();
    assertEquals(0, tree.size());
    assertEquals("[]", tree.toString());
    tree.add("x");
    assertEquals(1, tree.size());
    assertEquals("[x]", tree.toString());
  }

  /**
   * A test that verifies that add correctly inserts an
   * object into the tree when the tree is not empty.
   */
  @Test
  public void testAddNotEmptyTree() {
    assertEquals(7, tree1.size());
    assertEquals("[1 2 3 4 5 6 7]", tree1.toString());
    tree1.add(8);
    assertEquals(8, tree1.size());
    assertEquals("[1 2 3 4 5 6 7 8]", tree1.toString());
  }

  /**
   * A test that verifies that add behaves correctly when trying
   * to insert an object that is already in the tree.
   */
  @Test
  public void testAddAlreadyHave() {
    assertEquals(7, tree1.size());
    assertEquals("[1 2 3 4 5 6 7]", tree1.toString());
    tree1.add(1);
    tree1.add(2);
    tree1.add(3);
    tree1.add(4);
    tree1.add(5);
    tree1.add(6);
    tree1.add(7);
    assertEquals(7, tree1.size());
    assertEquals("[1 2 3 4 5 6 7]", tree1.toString());
  }

  /**
   * A test that verifies that size returns 0 when the tree is empty.
   */
  @Test
  public void testSizeEmptyTree() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertEquals(0, emptyTree.size());
  }

  /**
   * A test that verifies that size returns the correct value when the tree is not empty.
   */
  @Test
  public void testSizeNotEmptyTree() {
    assertEquals(7, tree1.size());
    tree1.add(8);
    assertEquals(8, tree1.size());
    assertEquals(8, tree2.size());
    tree2.add(10);
    assertEquals(9, tree2.size());
  }

  /**
   * A test that verifies that present returns true when an object is present in the tree.
   */
  @Test
  public void testPresentTrue() {
    assertTrue(tree1.present(5));
    assertTrue(tree2.present(8));
  }

  /**
   * A test that verifies that present returns false when an object is not present in the tree.
   */
  @Test
  public void testPresentFalse() {
    assertFalse(tree1.present(8));
    assertFalse(tree2.present(10));
  }

  /**
   * A test that verifies that minimum returns the smallest object in the tree.
   */
  @Test
  public void testMinimum() {
    assertEquals(Integer.valueOf(1), tree1.minimum());
    assertEquals(Integer.valueOf(1), tree2.minimum());
  }

  /**
   * A test that verifies that minimum returns null when the tree is empty.
   */
  @Test
  public void testMinimumNull() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertNull(emptyTree.minimum());
  }

  /**
   * A test that verifies that maximum returns the largest object in the tree.
   */
  @Test
  public void testMaximum() {
    assertEquals(Integer.valueOf(7), tree1.maximum());
    assertEquals(Integer.valueOf(8), tree2.maximum());
  }

  /**
   * A test the verifies that maximum returns null when the tree is empty.
   */
  @Test
  public void testMaximumNull() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertNull(emptyTree.maximum());
  }

  /**
   * A test that verifies that preOrder returns the correct string when the tree is empty.
   */
  @Test
  public void testPreOrderEmptyTree() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertEquals("[]", emptyTree.preOrder());
  }

  /**
   * A test that verifies that preOrder returns the correct string when the tree is not empty.
   */
  @Test
  public void testPreOrderNotEmptyTree() {
    assertEquals("[4 2 1 3 6 5 7]", tree1.preOrder());
    assertEquals("[6 4 2 1 3 5 7 8]", tree2.preOrder());
    assertNotEquals(tree2.inOrder(), tree1.inOrder());
  }

  /**
   * A test that verifies that inOrder returns the correct string when the tree is empty.
   */
  @Test
  public void testInOrderEmptyTree() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertEquals("[]", emptyTree.inOrder());
  }

  /**
   * A test that verifies that inOrder returns the correct string when the tree is not empty.
   */
  @Test
  public void testInOrderNotEmptyTree() {
    assertEquals("[1 2 3 4 5 6 7]", tree1.inOrder());
    assertEquals("[1 2 3 4 5 6 7 8]", tree2.inOrder());
    assertNotEquals(tree2.postOrder(), tree1.postOrder());
  }

  /**
   * A test that verifies that postOrder returns the correct string when the tree is empty.
   */
  @Test
  public void testPostOrderEmptyTree() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertEquals("[]", emptyTree.postOrder());
  }

  /**
   * A test that verifies that postOrder returns the correct string when the tree is not empty.
   */
  @Test
  public void testPostOrderNotEmptyTree() {
    assertEquals("[1 3 2 5 7 6 4]", tree1.postOrder());
    assertEquals("[1 3 2 5 4 8 7 6]", tree2.postOrder());
    assertNotEquals(tree2.preOrder(), tree1.preOrder());
  }

  /**
   * A test that verifies that height computes the correct height when the tree is empty.
   */
  @Test
  public void testHeightEmptyTree() {
    BinarySearchTree<Integer> emptyTree;
    emptyTree = new BinarySearchTreeImpl<>();
    assertEquals(0, emptyTree.height());
  }

  /**
   * A test that verifies that height computes the correct height when the tree is not empty.
   */
  @Test
  public void testHeightNotEmptyTree() {
    assertEquals(3, tree1.height());
    assertEquals(4, tree2.height());
  }


  /**
   * Test height when the height of the left and right subtrees are of different heights.
   */
  @Test
  public void testHeightDifferent() {
    BinarySearchTree<Integer> tree = new BinarySearchTreeImpl<>();
    tree.add(6);
    tree.add(5);
    tree.add(4);
    tree.add(3);
    assertEquals(4, tree.height());
    tree.add(2);
    tree.add(1);
    assertEquals(6, tree.height());
    tree.add(8);
    tree.add(9);
    tree.add(10);
    tree.add(11);
    assertEquals(6, tree.height());
    tree.add(12);
    tree.add(13);
    assertEquals(7, tree.height());
    tree.add(14);
    assertEquals(8, tree.height());
  }

}