package collections.list.generics;

public class BST<T extends Comparable<T>> implements BSTInt<T> {
    
    BSTNode<T> root;
    
    public BST() {
    
    }
    
    public void add(T val) {
        BSTNode<T> v = new BSTNode<>(val);
        if (root == null) {
            root = v;
            return;
        }
        add(root, v);
    }
    
    public void add(BSTNode<T> r, BSTNode<T> v) {
        if (r.data.compareTo(v.data) > 0) {
            if (r.left == null) {
                r.left = v;
                return;
            }
            add(r.left, v); 
        } else if (r.data.compareTo(v.data) < 0) {
            if (r.right == null) {
                r.right = v;
                return;
            }
            add(r.right, v);
        }
    }
    
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        System.out.println(bst);
        bst.add(12);
        bst.add(22);
        bst.add(7);
        System.out.println(bst.root);
    }
}