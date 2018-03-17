/**
 * generics
 * List.java
 */
package collections.list.generics;

public interface List<T> {

	/* add val to the end of the list */
	void add(T val);

	/* remove the element at idx and shift
	remaining elements to the left */
	T remove(int idx);

	/* return value of element at pos. idx */
	T get(int idx);

	/* set element at idx to val */
	void set(int idx, T val);

	/* sort list ascending */
	void sort();

	/* return number of elements in the list */
	int size();

	/* remove all elements from list */
	void clear();

	/* return index of first occurrence of
	val in list.  (-1 if not there) */
	int indexOf(T val);

	/* return true if list contains val,
	false otherwise */
	boolean contains(T val);

	/* return true if no more elements can
	be added to list */
	boolean isFull();

	/* return true if there are no elements */
	boolean isEmpty();

	/* insert a new element at specified index */
	void insert(int idx, T val);

	/* returned reversed elements */
	void reverse();
}
