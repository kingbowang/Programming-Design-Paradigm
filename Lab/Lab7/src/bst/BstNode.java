package bst;

/**
 * This interface represents all the operations to be supported by a binary search tee of object
 * type T.
 *
 * @param <T> The type of elements in the list.
 * @author Pengbo Wang
 */
public interface BstNode<T extends Comparable<T>> {
  /**
   * Add data to the Node. This is ignored if the data item is already present
   *
   * @param data the data to be added
   */
  BstNode<T> add(T data);

  /**
   * Gets the number of elements in the tree.
   *
   * @return the number of elements in the tree.
   */
  int size();

  /**
   * Gets the height the tree.
   *
   * @return the height of the tree.
   */
  int height();

  /**
   * Checks if the data is in the tree.
   *
   * @param data the data to check.
   * @return true if the data is present, false otherwise
   */
  boolean present(T data);

  /**
   * Determine and return the minimum data in the tree as defined by its ordering.
   *
   * @return the minimum data if it exists, null otherwise
   */
  T minimum();

  /**
   * Determine and return the maximum data in the tree as defined by its ordering.
   *
   * @return the maximum data if it exists, null otherwise
   */
  T maximum();

  /**
   * Returns a string that present all the data in the nodes, sorted in ascending order. The string
   * is formatted as "d1 d2 ... dn"
   *
   * @return a string containing the preorder traversal
   */
  String preOrder();

  /**
   * Returns a string that present all the data in the nodes in pre-order. sorted in ascending
   * order. The string is formatted as "d1 d2 ... dn"
   *
   * @return a string containing the inorder traversal
   */
  String inOrder();

  /**
   * Returns a string that present all the data in the nodes, sorted in ascending order. The string
   * is formatted as "d1 d2 ... dn"
   *
   * @return a string containing the postorder traversal
   */
  String postOrder();
}
