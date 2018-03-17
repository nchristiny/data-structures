/**
 * Generics
 * Node.java
 */
package collections.list.generics;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	T data;
	Node<T> next;

	public Node(T v) {
		data = v;
		next = null;
	}

	public Node() {
		data = null;
		next = null;
	}

	@Override
	public int compareTo(Node<T> that) {
		return this.data.compareTo(that.data);
	}

	@Override
	public String toString() {
		return "" + data;
	}
}
