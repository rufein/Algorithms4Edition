

 /****************************************************************************** 
 *   Exercise 1.3.48
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac TwoStackQueue.java
 *   Execution:    java TwoStackQueue < tobe.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoStackQueue<Item> implements Iterable<Item> {
 
    private Stack<Item> in;
    private Stack<Item> out;

   /**
   * Initialize
   */
    public TwoStackQueue() {
       in = new Stack<Item>();
       out = new Stack<Item>();
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return ( in.isEmpty() && out.isEmpty() );
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return ( in.size() + out.size() );
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
         
        return in.peek();
    }
    

    public void enqueue(Item item) {
        in.push(item);
    }

    public Item dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
               out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private int counter;
        
        private Stack<Item> temp;
        private Iterator<Item> itr_out;
        private Iterator<Item> itr_temp;

        public ListIterator() {
            // initialize variables
            counter = 0;
            temp = new Stack<Item>();
            
            Iterator<Item> itr_in = in.iterator();
            while( !itr_in.hasNext() ){
                Item i = itr_in.next();
                temp.push( i ) ;
            }
            
            // iterators
            itr_out =  out.iterator();
            itr_temp =  temp.iterator();
        }

        public boolean hasNext()  { return counter < out.size() + temp.size();  }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            
            if ( !itr_out.hasNext() ){
                return itr_out.next();
            }
            
            
            if( !itr_temp.hasNext() ){
                return itr_temp.next();
            }
            
            return null;
        }
    }

    /**
     * Unit tests the <tt>Bag</tt> data type.
     */
    public static void main(String[] args) {
        TwoStackQueue<String> q = new TwoStackQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        StdOut.println("size of Queue = " + q.size());
        
    }

    
}