package assn04;

public interface BST<T extends Comparable<T>> {

  BST<T> insert(T element);
  BST<T> remove(T element);

  void printPreOrderTraversal();
  BST<T> printPostOrderTraversal();
  int getHeight();

  T findMin();
  BST<T> getLeft();
  BST<T> getRight();
  T getElement();
  boolean isEmpty();
}
