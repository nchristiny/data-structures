package collections.list.generics;

public class BSTNode<T> {
    T data;
    BSTNode<T> left;
    BSTNode<T> right;
    
    public BSTNode(T val) {
      this.data = val;
      this.right = null;
      this.left = null;
    }
    
    public String toString() {
      return "" + this.data;
    }
}
