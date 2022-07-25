package bst;

/**
 * This represents a leaf node of the binary search tree implementation.
 *
 * @param <T> The type of leaf in this tree.
 * @author Pengbo Wang
 */
public class BstLeafNode<T extends Comparable<T>> implements BstNode<T> {

  @Override
  public BstNode<T> add(T data) {
    return new BstGroupNode<>(data, this, this);
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return "";
  }

  @Override
  public String inOrder() {
    return preOrder();
  }

  @Override
  public String postOrder() {
    return preOrder();
  }

  @Override
  public String toString() {
    return preOrder();
  }
}
