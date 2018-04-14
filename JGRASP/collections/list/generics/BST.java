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
    
    public int size() {
        return size(root);
    }
    
    public int size(BSTNode<T> r) {
        if (r == null){
            return 0;
        }
        return 1 + size(r.right) + size(r.left);
    }
    
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        System.out.println("Size of binary search tree before adding: ");
        System.out.println(bst.size());
        for (int i = 0; i < 31; i++) {
            int rnd = (int)(Math.random() * 50) + 1;
            bst.add(rnd);
        }
        System.out.println("Size of binary search tree after adding: ");
        System.out.println(bst.size());
    }
}
