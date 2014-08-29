
/****************************************************************************** 
 *   Exercise 1.3.14
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
 *
 *   Compilation:  javac ResizingArrayQueuOfStrings.java
 *   Execution:    java ResizingArrayQueuOfStrings
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueuOfStrings<Item> implements Iterable<Item> {
 
    private Item[] i; // Array
    private int N;
    
    /*
     * Constructor
     */
    public ResizingArrayQueuOfStrings(){
        // cast needed since no generic array creation in Java
        i = (Item[]) new Object[0];
        N = 0;
    }
    
    /*
     * Function to measure if the queue is empty 
    */
    public boolean isEmpty(){
        if ( N == 0) 
            return true; 
        return false; 
    }
    
    /*
     * Function that gice the size of the queue
    */
    public int size(){
        return N;
    }
    
    /*
     * Returns the item least recently added to this queue
    */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return i[N];
   }
   
   /**
   * Adds the item to this queue.
   */
    public void enqueue(Item item) {
        Item[] n = (Item[]) new Object[N + 1];
        for ( int h = 0; h < N ; h++ ){
            n[h] = i[h];
        }
        
        n[ N ] = item;
        N++;
        
        // Overwrite
        i = n;
    }

    /**
    * Removes and returns the item on this queue that was least recently added.
    */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        
        Item[] n = (Item[]) new Object[N - 1];
        for ( int h = 1; h < N ; h++ ){
            n[h-1] = i[h];
        }
        Item item = i[0];
        N--;
            
        // Overwrite
        i = n;
        
        return item;
    }

    /**
    * Returns a string representation of this queue.
    * @return the sequence of items in FIFO order, separated by spaces
    */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item i : this)
            s.append(i + " ");
        return s.toString();
    } 

    /**
    * Returns an iterator that iterates over the items in this queue in FIFO order.
    * @return an iterator that iterates over the items in this queue in FIFO order
    */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Item[] items;
        private int j;
        
        public ListIterator() {
            this.items = i;
            j = 0;
        }
      
        public boolean hasNext()  { return j < N; }
        public void remove()      { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item it = items[j];
            j++;
            return it;
        }
    }
    
    
  /*
   * Test function
  */
  public static void main(String[] args) { 
     ResizingArrayQueuOfStrings q = new ResizingArrayQueuOfStrings();
     q.enqueue("its ");
     q.enqueue("a ");
     q.enqueue("queue ");
     q.enqueue("and ");
     q.enqueue("you ");
     q.enqueue("dequeue ");
     StdOut.println( q.dequeue() );
     StdOut.println( q.dequeue() );
     StdOut.println( q.dequeue() );
     StdOut.println( q.dequeue() );
     StdOut.println( q.dequeue() );
     StdOut.println( q.dequeue() );
     
  }
}