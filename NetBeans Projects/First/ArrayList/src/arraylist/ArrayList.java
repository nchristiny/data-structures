/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package arraylist;
/*
* CS 304 Assignment 1: Customizing Java class and interface
*/

/**
 *
 * @author Nicholas Christiny
 */
public class ArrayList implements List {
    
    private int[] data;
    private int next;
    
    public ArrayList(int initialSize)
    {
        data = new int[initialSize];
        next = 0;
    }
    
    @Override
    public void add(int val)
    {
        data[next] = val;
        next = next + 1;
    }
    
    @Override
    public int remove(int idx)
            // return removed value and shift all higher indices, or return -1
    {
        if (idx >= next || idx < 0)
        {
            return -1;
        }
        int removedData = data[idx];
        for(int i = idx;i < next - 1;i++)
        {
            data[i] = data[i + 1];
        }
        next = next - 1;
        data[next] = 0;
        return removedData;
    }
    
    @Override
    public int get(int idx)
    {
        int value;
        value = this.data[idx];
        return value;
    }
    
    @Override
    public void set(int idx, int val)
    {
        data[idx] = val;
    }
    
    @Override
    public void sort()
            // Don't use Array.sort()
            // We could even make this more efficient by looping while checking boolean flag
    {
        for (int j = 0;j < next;j++) {
            for (int i = 1; i < next - j; i++)
            {
                if (data[i] < data[i - 1])
                {
                    int temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                }
            }
        }
    }
    
    @Override
    public int size()
    {
        int count = this.next;
        return count;
    }
    
    @Override
    public void clear()
    {
        next = 0;
    }
    
    @Override
    public int indexOf(int val)
            // Used in contains() method
    {
        for(int i = 0;i < next;i++){
            if (data[i] == val)
                return i;
        }
        return -1;
    }
    
    @Override
    public boolean isEmpty()
    {
        return (this.size() == 0);
    }
    
    @Override
    public boolean isFull()
    {
        // never full
        return false;
    }
    
    @Override
    public boolean contains(int val)
    {
        return (indexOf(val) != -1);
    }
    
    public void reverse()
    {
        
    }
    
    @Override
    public String toString() {
        // may implement iteratable in future
        String output = "";
        for(int i = 0; i < this.size(); i++)
        {
            if (i == this.size() - 1)
            {
                output = output + this.get(i);
            }
            else
                output = output + this.get(i) + ", ";
        }
        return output;
    }
}
