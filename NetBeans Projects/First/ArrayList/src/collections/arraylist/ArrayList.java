/*
 * CS 304 Assignment 1: Customizing Java class and interface
 */
package collections.arraylist;

/**
 * @author Nicholas Christiny
 * @param data Array of elements
 * @param next integer pointing to next in array
 */
public class ArrayList implements List {

    private int[] data;
    private int next;

    public ArrayList(int initialSize) {
        data = new int[initialSize];
        next = 0;
    }

    public void add(int val) {
        data[next] = val;
        next = next + 1;
    }

    public int remove(int idx) // @return removed value and shift all higher indices, or return -1 
    {
        if (idx >= next || idx < 0) {
            return -1;
        }
        int removedData = data[idx];
        for (int i = idx; i < next - 1; i++) {
            data[i] = data[i + 1];
        }
        next = next - 1;
        data[next] = 0;
        return removedData;
    }

    public int get(int idx) {
        int value;
        value = this.data[idx];
        return value;
    }

    public void set(int idx, int val) {
        data[idx] = val;
    }

    public void sort() // Don't use Array.sort()
    // TODO Looping while checking flag
    {
        for (int j = 0; j < next; j++) {
            for (int i = 1; i < next - j; i++) {
                if (data[i] < data[i - 1]) {
                    int temp = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = temp;
                }
            }
        }
    }

    public int size() {
        int count = this.next;
        return count;
    }

    public void clear() {
        next = 0;
    }

    public int indexOf(int val) // Used in contains() method
    {
        for (int i = 0; i < next; i++) {
            if (data[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public boolean isFull() {
        // never full
        return false;
    }

    public boolean contains(int val) {
        return (indexOf(val) != -1);
    }

    public void reverse() {
        for (int i = 0; i < this.size() / 2; i++) {
            // wish to switch elements only if necessary
            if (data[i] != data[this.size() - i - 1]) {
                int temp = data[i];
                data[i] = data[this.size() - i - 1];
                data[this.size() - i - 1] = temp;
            }
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.size(); i++) {
            if (i == this.size() - 1) {
                output = output + this.get(i);
            } else {
                output = output + this.get(i) + ", ";
            }
        }
        return output;
    }
}
