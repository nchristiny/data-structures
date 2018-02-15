package collections.list; 

public interface List {

    /* add val to the end of the list */
    void add(int val);

    /* remove the element at idx and shift 
      remaining elements to the left */
    int remove(int idx);

    /* return value of element at pos. idx */
    int get(int idx);

    /* set element at idx to val */
    void set(int idx, int val);

    /* sort list ascending */
    void sort();

    /* return number of elements in the list */
    int size();

    /* remove all elements from list */
    void clear();

    /* return index of first occurrence of 
      val in list.  (-1 if not there) */
    int indexOf(int val);

    /* return true if list contains val, 
      false otherwise */
    boolean contains(int val);

    /* return true if no more elements can
      be added to list */
    boolean isFull();

    /* return true if there are no elements */
    boolean isEmpty();

    /* insert a new element at specified index */
    void insert( int idx, int val );
}
