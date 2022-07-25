package bst;

/**
 * This is a group node in a binary search tree.
 * It contains the data and the rest of the tree.
 *
 * @param <T> The type of group node in the tree.
 * @author Pengbo Wang
 */
public class BstGroupNode<T extends Comparable<T>> implements BstNode<T> {
  private final T data;
  private BstNode<T> left;
  private BstNode<T> right;

  /**
   * Constructor.
   *
   * @param data  data in the group node
   * @param left  left node
   * @param right right node
   */
  public BstGroupNode(T data, BstNode<T> left, BstNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  @Override
  public BstNode<T> add(T data) {
    if (this.data.compareTo(data) < 0) {
      right = this.right.add(data);
    } else if (this.data.compareTo(data) > 0) {
      left = this.left.add(data);
    }
    return this;
  }

  @Override
  public int size() {
    return 1 + left.size() + right.size();
  }

  @Override
  public int height() {
    return Math.max(1 + left.height(), 1 + right.height());
  }

  @Override
  public boolean present(T data) {
    if (data.compareTo(this.data) == 0) {
      return true;
    } else if (data.compareTo(this.data) < 0) {
      return left.present(data);
    } else {
      return right.present(data);
    }
  }

  @Override
  public T minimum() {
    T min = left.minimum();
    if (min != null) {
      return min;
    }
    return this.data;
  }

  @Override
  public T maximum() {
    T max = right.maximum();
    if (max != null) {
      return max;
    }
    return this.data;
  }

  @Override
  public String preOrder() {
    String orderString = this.data.toString();
    String left = this.left.preOrder();
    if (left.length() > 0) {
      orderString = orderString + " " + left;
    }
    String right = this.right.preOrder();
    if (right.length() > 0) {
      return orderString + " " + right;
    }
    return orderString;
  }

  @Override
  public String inOrder() {
    String orderString = "";
    String left = this.left.inOrder();
    if (left.length() > 0) {
      orderString = orderString + left + " ";
    }
    orderString = orderString + this.data.toString();
    String right = this.right.inOrder();
    if (right.length() > 0) {
      return orderString + " " + right;
    }
    return orderString;
  }

  @Override
  public String postOrder() {
    String orderString = "";
    String left = this.left.postOrder();
    if (left.length() > 0) {
      orderString = orderString + left + " ";
    }
    String right = this.right.postOrder();
    if (right.length() > 0) {
      orderString = orderString + right + " ";
    }
    orderString = orderString + this.data.toString();
    return orderString;
  }

  @Override
  public String toString() {
    return inOrder();
  }
}
